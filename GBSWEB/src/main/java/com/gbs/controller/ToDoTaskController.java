/**
 * 
 */
package com.gbs.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gbs.delegate.ApplyInfoRuleDelegate;
import com.gbs.dto.APPLY_INFO_DTO;
import com.gbs.dto.ApprovalInfoDto;
import com.gbs.dto.UserInfoDto;
import com.gbs.dto.Variable;
import com.gbs.service.ApprovalService;
import com.gbs.util.UserUtil;
import com.ibm.rules.decisionservice.gbs_rule.gbs_dc.ResponseInfo;

/**
 * @author HuangLiPing
 *
 */
@Controller
@RequestMapping(value = "/approval")
public class ToDoTaskController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ApprovalService approvalService;
	
	@Autowired
	private ApplyInfoRuleDelegate ruleDelegate;
	
	 /**
     * 任务列表
     *
     * @param
	 * @throws Exception 
     */
//    @RequestMapping(value = "task")
//    public ModelAndView taskList(HttpSession session, HttpServletRequest request) throws Exception {
//        ModelAndView mav = new ModelAndView("/approval/taskList");
//        
//        String action = request.getParameter("action");
//        logger.info("Action = " + action);
//
//        UserInfoDto userInfo = UserUtil.getUserFromSession(session);
//        String userId = userInfo.getUserid();
//        logger.info("userId = " + userId);
//        
//        List<ApprovalInfoDto> approvalInfos = approvalService.findTodoTasks(userId);
//        
//        logger.info("task size = " + (approvalInfos!=null?approvalInfos.size():0));
//        
//        mav.addObject("approvalInfos", approvalInfos);
//        mav.addObject("action", action);
//        
//        return mav;
//    }
    
    /**
     * 任务列表
     *
     * @param
	 * @throws Exception 
     */
    @RequestMapping(value = "task")
    public ModelAndView findTaskList(HttpSession session, HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView("/approval/taskList");
        
        String action = request.getParameter("action");
        logger.info("Action = " + action);

        UserInfoDto userInfo = UserUtil.getUserFromSession(session);
        String userId = userInfo.getUserid();
        logger.info("userId = " + userId);
        
        List<ApprovalInfoDto> approvalInfos = approvalService.findTodoTasks(userId, action);
        
        logger.info("task size = " + (approvalInfos!=null?approvalInfos.size():0));
        
        mav.addObject("approvalInfos", approvalInfos);
        mav.addObject("action", action);
        
        return mav;
    }
    
    /**
     * 签收
     * @param taskId
     * @param session
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "task/claim/{id}//{action}")
    public String claimTask(@PathVariable("id") String taskId, @PathVariable("action") String action,
    		HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
    	logger.info("taskId = " + taskId);
    	logger.info("action = " + action);
    	String userId = UserUtil.getUserFromSession(session).getUserid();
    	logger.info("userId = " + userId);
        approvalService.claimTask(userId, taskId);
        
        redirectAttributes.addFlashAttribute("message", "任务已签收");
        
        return "redirect:/approval/task?action="+action;
    }
    
    @RequestMapping(value = "complete/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String completeTask(@PathVariable("id") String taskId, Variable var, HttpSession session) {
    	logger.info("taskId = " + taskId);
    	
        try {
            Map<String, Object> variables = var.getVariableMap();
            String userId = UserUtil.getUserFromSession(session).getUserid();
            
            approvalService.completeTask(userId, taskId, variables);
            return "success";
        } catch (Exception e) {
            logger.error("error on complete task {}, variables={}", new Object[]{taskId, var.getVariableMap(), e});
            return "error";
        }
    }
    

    /**
     * 读取详细数据
     *
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "detail/{id}")
    public @ResponseBody APPLY_INFO_DTO getDetail(@PathVariable("id") String id) throws Exception {
    	logger.info("businesskey = " + id);
    	
    	APPLY_INFO_DTO applyInfo = approvalService.findApplyInfo(id);
    	
    	ResponseInfo ruleInfo = ruleDelegate.firstCheck(id);
    	
    	logger.info("ruleInfo = " + ruleInfo);
    	if(ruleInfo != null) {
    	    logger.info("ruleInfo detail = " + ruleInfo.getCode() + "," + ruleInfo.getResultName() + "," + ruleInfo.getResultDescription());
    	}
    	applyInfo.setRuleInfo(ruleInfo);
    	
        return applyInfo;
    }
    
    /**
     * 读取详细数据
     *
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "detailWithVars/{id}/{taskId}")
    @ResponseBody
    public APPLY_INFO_DTO getDetailWithVars(@PathVariable("id") String id, @PathVariable("taskId") String taskId) throws Exception {
        logger.info("businesskey = " + id);
    	
    	APPLY_INFO_DTO applyInfo = approvalService.findApplyInfoWithVar(id, taskId);
    	
        return applyInfo;
    }

}
