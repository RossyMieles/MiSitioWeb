package com.carros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.carros.dao.CarrosDAO;
import com.carros.model.Carro;

public class CarrosController {
	
	@Autowired
	CarrosDAO carrosDAO;
	
	public void insertar(Carro carro){
		carrosDAO.insertar(carro);
	}
	
	public void cambiar(Carro carro){
		carrosDAO.cambiar(carro);
	}
	
	public void eliminar(Carro carro){
		carrosDAO.eliminar(carro);
	}
	
	public List<Carro> listarTodos(){
		return carrosDAO.listarTodos();
	}
	
}
