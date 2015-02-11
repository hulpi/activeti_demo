
package com.gbs.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Service;

import com.gbs.constant.ApplyStatus;
import com.gbs.dao.ApplyInfoDao;
import com.gbs.dto.APPLY_INFO_DTO;
import com.gbs.dto.ApprovalInfoDto;
import com.gbs.entity.GU_APPLY_INFO;
import com.gbs.entity.GU_INDIVIDUAL_INFO;
import com.gbs.service.ApprovalService;
import com.uaf.grtwf.webservice.ApprovalWebService;
import com.uaf.grtwf.webservice.ApprovalWebService_Service;
import com.uaf.grtwf.webservice.Exception_Exception;
import com.uaf.grtwf.webservice.MapEntity;
import com.uaf.grtwf.webservice.MapEntityArray;
import com.uaf.grtwf.webservice.TaskDto;

/**
 * @author HuangLiPing
 */
@Service
public final class ApprovalServiceImpl implements ApprovalService {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

    private static final QName SERVICE_NAME = new QName("http://webservice.grtwf.uaf.com/", "ApprovalWebService");
    
    @Autowired
	private ApplyInfoDao applyInfoDao;
    
    private URL wsdlURL = ApprovalWebService_Service.WSDL_LOCATION;
    private ApprovalWebService port;
    
    private String url = "http://localhost:8080/uaf-grtwf/webservices/approval?wsdl";
    
    private Map<String, String> taskMap;
    
    public ApprovalServiceImpl() {
    	try {
			ResourcePropertySource propertySource = new ResourcePropertySource("resource", "classpath:grtwf.properties");
			String property = (String)propertySource.getProperty("wsdlUrl");
			if(property != null) {
				url = (String)property;
			}
			logger.debug("url = " + url);
			
			taskMap = new HashMap<String, String>();
			taskMap.put("check", "usertask2");
			taskMap.put("audit", "usertask3");
			taskMap.put("approve", "usertask4");
			taskMap.put("advanceApprove", "usertask6");
			taskMap.put("back", "usertask5");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private void init() throws MalformedURLException {
    	try {
    		if(port == null) {
    			logger.debug("##init start...");
				wsdlURL = new URL(url);
		        ApprovalWebService_Service ss = new ApprovalWebService_Service(wsdlURL, SERVICE_NAME);
		        port = ss.getApprovalServicePort();
		        
		        logger.debug("init end...");
    		}
//	        Map<String, Object> requestContext =
//	          	  ((javax.xml.ws.BindingProvider)port).getRequestContext();
//	         String endPointAddress = (String)requestContext.get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
//	         String target = "http://localhost:8080/uaf-grtwf/webservices/approval";
//	         requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, target);
	         
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw e;
		}
    }
    
    public String startApprovalProcess(String userId, String businessKey) throws MalformedURLException {

    	init();
    	
        MapEntityArray _startProcess_arg2 = null;
        try {
        	

            String _startProcess__return = port.startProcess(userId, businessKey, _startProcess_arg2);
            
            return _startProcess__return;
            
        } catch (Exception_Exception e) {
        	
        	throw new RuntimeException(e);

        }
        
    }
    
    private List<ApprovalInfoDto> assembleApprovalDto(List<TaskDto> tasks, List<GU_APPLY_INFO> applyInfos) {
    	if(tasks == null) {
    		return null;
    	}
    	Map<String, APPLY_INFO_DTO> applyInfoMap = new HashMap<String, APPLY_INFO_DTO>();
    	if(applyInfos != null) {
    		for(GU_APPLY_INFO applyInfo : applyInfos) {
    			String processId = applyInfo.getProcess_instance_id();
    			APPLY_INFO_DTO applyDto = new APPLY_INFO_DTO();
    			applyDto.setGuarant_id(applyInfo.getGuarant_id());
    			applyDto.setGuarant_amt(applyInfo.getGuarant_amt().toString());
    			GU_INDIVIDUAL_INFO individual = applyInfo.getIndividual();
    			if(individual != null) {
    				applyDto.setCustName(individual.getCUST_NAME());
    			}
    			
    			applyInfoMap.put(processId, applyDto);
    		}
    	}
    	
    	List<ApprovalInfoDto> approvalInfos = new ArrayList<ApprovalInfoDto>();
    	
    	for(TaskDto taskDto : tasks) {
    		ApprovalInfoDto approvalInfoDto = new ApprovalInfoDto();
    		String processInstanceId = taskDto.getProcessInstanceId();
    		approvalInfoDto.setTaskDto(taskDto);
    		approvalInfoDto.setApplyInfo(applyInfoMap.get(processInstanceId));
    		
    		approvalInfos.add(approvalInfoDto);
    	}
    	
    	return approvalInfos;
    	
    }
    
    
    public List<ApprovalInfoDto> findTodoTasks(String userId, String action) throws Exception {
    	init();
    	
        try {
        	String taskKey = action!=null?taskMap.get(action):null;
        	logger.debug("taskKey = " + taskKey);
        	
            List<TaskDto> tasks = port.findTodoTasks(userId, taskKey);
            
            if(tasks != null && !tasks.isEmpty()) {
            	List<String> processInstanceIds = new ArrayList<String> ();
            	
            	for(TaskDto taskDto: tasks) {
            		String processInstanceId = taskDto.getProcessInstanceId();
            		processInstanceIds.add(processInstanceId);
            		logger.debug("definitionKey = " + taskDto.getTaskDefinitionKey());
            	}
            	
            	List<GU_APPLY_INFO> applyInfos = applyInfoDao.queryApplyInfoByProcessInstanceIds(processInstanceIds);
            	
            	List<ApprovalInfoDto> approvalDtos = assembleApprovalDto(tasks, applyInfos);
            	
            	return approvalDtos;
            }
            
            return null;


        } catch (Exception_Exception e) { 
            throw new RuntimeException(e);
        }
    }
    
    public void claimTask(String userId, String taskId, String action, String guaranId) {
        try {
            port.claimTask(userId, taskId);
            
            String status = ApplyStatus.statusMap.get(action);
            if(status != null) {
            	applyInfoDao.updateStatus(guaranId, status);
            }
            

        } catch (Exception_Exception e) { 
        	throw new RuntimeException(e);
        	
        }
        
    }
    
    public void completeTask(String userId, String taskId, String guaranId, String status, Map<String, Object> variables) {
        MapEntityArray entityArray = new MapEntityArray();
        if(variables != null) {
        	for(String key : variables.keySet()) {
        		Object obj = variables.get(key);
        		MapEntity mapEntity = new MapEntity();
        		mapEntity.setKey(key);
        		mapEntity.setValue(obj);
        		
        		entityArray.getItem().add(mapEntity);
        	}
        }
        
        try {
        	
            port.completeTask(userId, taskId, entityArray);
            
            if(guaranId != null) {
            	applyInfoDao.updateStatus(guaranId, status);
            }

        } catch (Exception_Exception e) { 
        	throw new RuntimeException(e);

        }
    }
    
    private APPLY_INFO_DTO assembleApplyInfoDTO (GU_APPLY_INFO applyInfo) {
    	APPLY_INFO_DTO applyInfoDto = new APPLY_INFO_DTO();
    	
    	applyInfoDto.setGuarant_id(applyInfo.getGuarant_id());
		applyInfoDto.setGuarant_amt(applyInfo.getGuarant_amt().toString());
		applyInfoDto.setLoan_purpose(applyInfo.getLoan_purpose());
		applyInfoDto.setProductSel(applyInfo.getProduct().getProduct_desc());
		applyInfoDto.setGuarant_time_limit(applyInfo.getGuarant_time_limit().toString());
		
		return applyInfoDto;
    }
    
    public APPLY_INFO_DTO findApplyInfo(String guaranId) throws Exception {
    	APPLY_INFO_DTO applyInfoDto = new APPLY_INFO_DTO();
    	GU_APPLY_INFO applyInfo = applyInfoDao.getApplyInfoByGuarantId(guaranId);
    	if(applyInfo != null) {
    		logger.debug("guarant id = " + applyInfo.getGuarant_id());
    		logger.debug("guarant amount = " + applyInfo.getGuarant_amt());
    		applyInfoDto = assembleApplyInfoDTO(applyInfo);
    		
    	}
    	
    	return applyInfoDto;
    }

	@Override
	public APPLY_INFO_DTO findApplyInfoWithVar(String guaranId, String taskId) throws Exception {
		APPLY_INFO_DTO applyInfoDto = findApplyInfo(guaranId);
		MapEntityArray entityArray = port.getVariables(taskId);
		Map<String, Object> varMap = new HashMap<String, Object>();
		if(entityArray != null) {
			for(MapEntity mapEntity : entityArray.getItem()) {
				varMap.put((String)mapEntity.getKey(), mapEntity.getValue());
			}
		}
		
		applyInfoDto.setVariables(varMap);
		
		return applyInfoDto;
	}

}
