package com.example.Rebeca.PrjEmpresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Rebeca.PrjEmpresa.entities.Funcionário;

public interface FuncionárioRepository extends JpaRepository<Funcionário, Long>{

	@Query("SELECT f FROM Funcionário f WHERE LOWER(f.funnome) LIKE LOWER(CONCAT('%', :funnome, '%'))")
	List<Funcionário> findByNomeContaining(@Param("funnome") String funnome);
}
