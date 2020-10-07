package br.com.coti.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages="br.com.coti.entity")
@EnableJpaRepositories(basePackages="br.com.coti.repository")
@ComponentScan(basePackages="br.com.coti.controllers")
public class Application {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		}
	
	/*
	  create database panters;
	  use panters;
	  
	  insert into livro(nome, preco) values
	  ('sr dos anels','200'),
	  ('rambo','20'),
	  ('harry potter','400');
	 */
}
