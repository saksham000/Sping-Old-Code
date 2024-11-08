package com.firstproject.firstproject.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	private Dependency dependency;

	public SomeClass(Dependency dependency){
		super();
		this.dependency = dependency;
		System.out.println("All Dependecy are ready");
	}

	@PostConstruct
	public void initialize(){
		dependency.getReady();
	}

	@PreDestroy
	public void cleanUp(){
		System.out.println("Terminating the resources");
	}
}

@Component
class Dependency{

	public void getReady() {
		System.out.println("Some Logic using Dependecy");
	}

}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}
	}
}
