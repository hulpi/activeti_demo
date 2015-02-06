/**
 * 
 */
package com.uaf.grtwf.service;

import static org.junit.Assert.*;

import java.util.List;

import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiTestCase;
import org.junit.Test;

/**
 * @author wb00003
 *
 */
public class ApprovalWorkflowServiceTest extends ActivitiTestCase {

	/**
	 * Test method for {@link com.uaf.grtwf.service.ApprovalWorkflowService#startWorkflow(java.lang.String, java.lang.String, java.util.Map)}.
	 */
	@Test
	public void testStartWorkflow() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.uaf.grtwf.service.ApprovalWorkflowService#gotoNextTask(java.lang.String, java.lang.String, java.util.Map)}.
	 */
	@Test
	public void testGotoNextTask() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.uaf.grtwf.service.ApprovalWorkflowService#findTodoTasks(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testFindTodoTasks() {
		//runtimeService.startProcessInstanceByKey("taskDefinitionKeyProcess");
		
		List<Task> tasks = taskService.createTaskQuery().taskDefinitionKey("usertask2").list();
		System.out.println("tasks size = " + tasks.size());
		
		tasks = taskService.createTaskQuery().taskCandidateOrAssigned("admin").list();
		System.out.println("tasks size = " + tasks.size());
		
		tasks = taskService.createTaskQuery().taskCandidateOrAssigned("admin").taskDefinitionKey("usertask2").list();
		System.out.println("tasks size = " + tasks.size());
		
		tasks = taskService.createTaskQuery().taskDefinitionKey("usertask2").list();
		System.out.println("tasks size = " + tasks.size());
		
		tasks = taskService.createTaskQuery().taskDefinitionKeyLike("usertask2").list();
		System.out.println("tasks size = " + tasks.size());
		
		
	}

	/**
	 * Test method for {@link com.uaf.grtwf.service.ApprovalWorkflowService#findRunningProcessInstaces(java.lang.String, int[])}.
	 */
	@Test
	public void testFindRunningProcessInstaces() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.uaf.grtwf.service.ApprovalWorkflowService#findFinishedProcessInstaces(java.lang.String, int[])}.
	 */
	@Test
	public void testFindFinishedProcessInstaces() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.uaf.grtwf.service.ApprovalWorkflowService#getTaskVars(java.lang.String)}.
	 */
	@Test
	public void testGetTaskVars() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.uaf.grtwf.service.ApprovalWorkflowService#complete(java.lang.String, java.util.Map)}.
	 */
	@Test
	public void testComplete() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.uaf.grtwf.service.ApprovalWorkflowService#claim(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testClaim() {
		fail("Not yet implemented");
	}

}
