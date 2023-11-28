package com.example.Rebeca.PrjEmpresa.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rebeca.PrjEmpresa.entities.Departamento;
import com.example.Rebeca.PrjEmpresa.service.DepartamentoService;


@RestController
@RequestMapping("/departamento")
public class DepartamentoControler {

		private DepartamentoService departamentoService;

		@Autowired
		public void LivroController(DepartamentoService departamentoService) {
			this.departamentoService = departamentoService;
		}

		@PostMapping("/")
		public Departamento createclient(@RequestBody Departamento departamento) {
			return departamentoService.saveDepartamento(departamento);

		}

		@GetMapping("/{Depcodigo}")
		public ResponseEntity<Departamento> getDepartamento(@PathVariable Long Depcodigo) {
			Departamento departamento = departamentoService.getDepartamentoByDepcodigo(Depcodigo);
			if (departamento != null) {
				return ResponseEntity.ok(departamento);
			} else {
				return ResponseEntity.notFound().build();
			}

		}

		@GetMapping("/home")
		public String paginaInicial() {
			return "index";
		}

		@DeleteMapping("/{Depcodigo}")
		public void deleteiddepartamento(@PathVariable Long id) {
			departamentoService.Deletedepartamento(id);
		}

		// Utilizando o ResponseEntity e RequestEntity
		@GetMapping("/")
		public ResponseEntity<List<Departamento>> getAllDepartamento(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Departamento> departamento = departamentoService.getAllDepartamento();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(departamento);
		}

		@PutMapping("/{Depcodigo}")
		public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
			return departamentoService.updateDepartamento(id, departamento );
		}

	
}

