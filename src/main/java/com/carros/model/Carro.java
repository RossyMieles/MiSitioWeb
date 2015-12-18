package com.carros.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="carros")
@NamedQuery(name="Carro.findAll", query="SELECT c FROM Carro c")
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcodigo;

	private String marca;

	public Carro() {
	}
	
	public Carro(Integer idcodigo, String marca) {
		super();
		this.idcodigo = idcodigo;
		this.marca = marca;
	}

	public Integer getIdcodigo() {
		return this.idcodigo;
	}

	public void setIdcodigo(Integer idcodigo) {
		this.idcodigo = idcodigo;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}