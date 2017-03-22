# The Spring Boot - Activiti integration

#### Requirement - 
To create api's exposing Activiti Process Engine which can be consumed in any web interface applications.

#### Pre-requisites 
 - JDK 7+
 - activiti-spring-boot-starter-basic Version - 5.18.0
 - spring-boot-starter-web - to expose REST Interface Version - 1.4.0.RELEASE
 - spring-context - Not Documented officially however, required in some case to avoid build errors. Version - 4.3.2.RELEASE
 - junit - For unit testing. Version - 3.8.1
 - activiti-engine - for obivious resons - Version 5.18.0
 - activiti-spring - Version - 5.18.0
 - mysql-connector-java - for making jdbc connection to mysql server, H2 or postgres can be used as alternate. Version - 5.1.34
 - tomcat-jdbc - Version - 8.0.15


#### Main Application Class - For Starting and running the application -

    
	import org.activiti.engine.RepositoryService;
	import org.activiti.engine.RuntimeService;
	import org.activiti.engine.TaskService;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
	import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	import javax.sql.DataSource;

	@Configuration
	@ComponentScan
	@EnableAutoConfiguration
	public class MyApplication {

		public static void main(String[] args) {
			SpringApplication.run(MyApplication.class, args);
		}

		@Bean
	    public CommandLineRunner init(final RepositoryService repositoryService,
					  final RuntimeService runtimeService,
					  final TaskService taskService) {

		return new CommandLineRunner() {
		    public void run(String... strings) throws Exception {
			System.out.println("Number of process definitions : "
				+ repositoryService.createProcessDefinitionQuery().count());
			System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
			runtimeService.startProcessInstanceByKey("oneTaskProcess");
			System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
		    }
		};

	    }	
	}
    

#### Data Base configuration - Part of main application class

    
	@Bean
	public DataSource database(){
		// TODO change the connection url & details for different DB
		return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/activiti-spring-boot?characterEncoding=UTF-8")
				.username("Jeetendra")
				.password("abcd1234")
				.driverClassName("com.mysql.jdbc.Driver")
				.build();
	}
    
