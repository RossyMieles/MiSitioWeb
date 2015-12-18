package com.carros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.carros.controller.CarrosController;

@Configuration
public class CarrosConfig {
	
	@Bean
	public CarrosController carrosController(){
		CarrosController carrosController = new CarrosController();
		return carrosController;
	}
	
}
