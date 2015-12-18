package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.carros.controller.CarrosController;
import com.carros.model.Carro;

public class CarroTestAn {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("appContext.xml");
		CarrosController carrosController = context.getBean("carrosController", CarrosController.class);
		
		// carrosController.insertar(new Carro(9, "GreatWall"));
		// carrosController.cambiar(new Carro(9, "Cherokee"));
		// carrosController.eliminar(new Carro(9, "Cherokee"));
		
		List<Carro> lista = carrosController.listarTodos();
		
		for(Carro c: lista)
			System.out.println(c);
	}
}
