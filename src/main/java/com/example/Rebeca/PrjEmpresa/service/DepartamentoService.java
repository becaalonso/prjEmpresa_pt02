package com.example.Rebeca.PrjEmpresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Rebeca.PrjEmpresa.entities.Departamento;
import com.example.Rebeca.PrjEmpresa.repository.DepartamentoRepository;


@Service
public class DepartamentoService {
	private final DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository){
    this.departamentoRepository = departamentoRepository;
	}

	public Departamento getDepartamentoByDepcodigo(Long Depcodigo) {
		return departamentoRepository.findById(Depcodigo).orElse(null);

	}

	public List<Departamento> getAllDepartamento() {
		return departamentoRepository.findAll();
	}

	public Departamento saveDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	public void Deletedepartamento(Long Depcodigo) {
		departamentoRepository.deleteById(Depcodigo);
	}

	// fazendo o update do livro com o optional
	public Departamento updateDepartamento(Long Depcodigo, Departamento novoDepartamento) {
		Optional<Departamento> DepartamentoOptional = departamentoRepository.findById(Depcodigo);
		if (DepartamentoOptional.isPresent()) {
			Departamento DepartamentoExistente = DepartamentoOptional.get();
			DepartamentoExistente.setDepnome(novoDepartamento.getDepnome());
			return departamentoRepository.save(DepartamentoExistente);
		} else {
			return null;
		}
	}
}
