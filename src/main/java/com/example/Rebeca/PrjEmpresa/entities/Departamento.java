package com.example.Rebeca.PrjEmpresa.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbDepartamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Depcodigo;

	private String Depnome;

	public Departamento() {

	}

	public Departamento(Long Depcodigo, String Depnome) {
		super();
		this.Depcodigo = Depcodigo;

		this.Depnome = Depnome;
	}

	public Long getDepcodigo() {
		return Depcodigo;
	}

	public void setDepcodigo(Long Depcodigo) {
		this.Depcodigo = Depcodigo;
	}

	public String getDepnome() {
		return Depnome;
	}

	public void setDepnome(String Depnome) {
		this.Depnome = Depnome;
	}

	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
