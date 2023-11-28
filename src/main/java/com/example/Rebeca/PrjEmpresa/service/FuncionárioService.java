package com.example.Rebeca.PrjEmpresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.Rebeca.PrjEmpresa.entities.Departamento;
import com.example.Rebeca.PrjEmpresa.entities.Funcionário;
import com.example.Rebeca.PrjEmpresa.repository.DepartamentoRepository;
import com.example.Rebeca.PrjEmpresa.repository.FuncionárioRepository;

@Service
public class FuncionárioService {
	
	@Autowired
	private FuncionárioRepository funcionarioRepository;

	public List<Funcionário> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public Funcionário getFuncionarioById(long funcodigo) {
		return funcionarioRepository.findById(funcodigo).orElse(null);
	}

	public Funcionário saveFuncionario(Funcionário funcionário) {
		return funcionarioRepository.save(funcionário);
	}

	public List<Funcionário> getFuncionariosByFunnomeAproximado(String funnome) {
        return funcionarioRepository.findByNomeContaining(funnome);
    }

	public boolean deleteFuncionario(Long id) {
		Optional<Funcionário> funcionárioExistente = funcionarioRepository.findById(id);
		if (funcionárioExistente.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Funcionário updateFuncionario(Long funcodigo, Funcionário novoFuncionario) {
		Optional<Funcionário> funcionarioOptional = funcionarioRepository.findById(funcodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionário funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
			funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());

			// Atualize o departamento
			if (novoFuncionario.getDepartamento() != null) {
				funcionarioExistente.setDepartamento(novoFuncionario.getDepartamento());
			}		
			return funcionarioRepository.save(funcionarioExistente);
		} else {
			return null; // Ou lançar uma exceção indicando que o funcionário não foi encontrado
		}
	}
}
