package com.dharani.springjdbcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dharani.springjdbcdemo.model.Alien;
import com.dharani.springjdbcdemo.model.repo.AlienRepo;

@SpringBootApplication
public class SpringjdbcdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringjdbcdemoApplication.class, args);

		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(111);
		alien1.setName("Dharani");
		alien1.setTech("Java");

		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien1);
		System.out.println(repo.findall());

		System.out.println("hello");
	}

}
