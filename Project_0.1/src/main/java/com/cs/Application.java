package com.cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cs.bean.Car;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		Car car = applicationContext.getBean(Car.class);
//		System.out.println("Car Name: " + car.getCarName());
		
		String[] allBeans = applicationContext.getBeanDefinitionNames();
		System.out.println("\nBeans in IoC Container: ");
		for (String beanName : allBeans) {
			System.out.println(beanName);
		}
	}

}
