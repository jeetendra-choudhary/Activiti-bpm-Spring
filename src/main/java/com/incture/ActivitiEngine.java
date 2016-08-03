package com.incture;

import org.activiti.engine.RepositoryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ActivitiEngine {

	// Load the IOC configuration
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringIntegration-context.xml");
	RepositoryService repositoryService = (RepositoryService) context.getBean("repositoryService");
	
	String deploymentId = repositoryService.createDeployment()
			.addClasspathResource("org/activiti/spring/test/hello.bpmn20.xml").deploy().getId();

}
