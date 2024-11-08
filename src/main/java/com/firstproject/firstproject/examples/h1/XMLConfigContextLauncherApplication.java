package com.firstproject.firstproject.examples.h1;

import java.util.Arrays;


import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XMLConfigContextLauncherApplication {

	public static void main(String[] args) {

		try (var context = new ClassPathXmlApplicationContext("ContextConfiguration.xml")) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean("name"));
		}
	}
}
