package me.kafeitu.demo.activiti.service.apply;

import me.kafeitu.demo.activiti.dao.ApplicationDao;
import me.kafeitu.demo.activiti.entity.customer.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 申请实体管理
 *
 * @author HuangLiPing
 */
@Component
@Transactional(readOnly = true)
public class ApplicationManager {

    private ApplicationDao applicationDao;

    public Application getApplication(Long id) {
        return applicationDao.findOne(id);
    }

    @Transactional(readOnly = false)
    public void saveApplication(Application entity) {
        if (entity.getId() == null) {
            entity.setApplyTime(new Date());
        }
        applicationDao.save(entity);
    }

    @Autowired
	public void setApplicationDao(ApplicationDao applicationDao) {
		this.applicationDao = applicationDao;
	}

    
   

}
