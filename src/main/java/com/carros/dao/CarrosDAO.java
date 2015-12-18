package com.carros.dao;

import java.util.List;

import com.carros.model.Carro;

public interface CarrosDAO {
	public void insertar(Carro carro);
	public void cambiar(Carro carro);
	public void eliminar(Carro carro);
	public List<Carro> listarTodos();
}
