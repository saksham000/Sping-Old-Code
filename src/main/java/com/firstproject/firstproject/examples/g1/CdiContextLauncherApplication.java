package com.firstproject.firstproject.examples.g1;

import java.util.Arrays;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import jakarta.inject.Inject;
import jakarta.inject.Named;

// @Component
@Named
class Business {
	private DataService dataService;

	// @Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Seter injection is done");
		this.dataService = dataService;
	}

	public DataService getDataService() {

		return dataService;
	}

}

@Named
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(Business.class).getDataService());

		}
	}
}
