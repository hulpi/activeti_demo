package me.kafeitu.demo.activiti.dao;

import me.kafeitu.demo.activiti.entity.customer.Application;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * 申请实体管理接口
 *
 * @author HuangLiPing
 */
@Component
public interface ApplicationDao extends CrudRepository<Application, Long> {
}
