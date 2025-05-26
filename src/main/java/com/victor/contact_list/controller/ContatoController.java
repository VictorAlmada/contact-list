package com.victor.contact_list.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.contact_list.dto.ContatoDTO;
import com.victor.contact_list.service.ContatoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contatos")
@RequiredArgsConstructor
public class ContatoController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContatoController.class);
	
	private final ContatoService service;
	
	
	// mostrar todos
	@GetMapping
	public ResponseEntity<List<ContatoDTO>> getAll() {
		logger.info("🖥 getAll concluído com sucesso!");
		return ResponseEntity.ok(service.findAll());
	}
	
	// buscar por ID
	@GetMapping("/{id}")
	public ResponseEntity<ContatoDTO> getById(@PathVariable Long id) {
		logger.info("🖥 getById=" + id + " concluído com sucesso!");
		return ResponseEntity.ok(service.findById(id));
	}
	
	// criar
	@PostMapping
	public ResponseEntity<ContatoDTO> create(@RequestBody ContatoDTO dto) {
		logger.info("🖥 Contato criado com sucesso!");
		return ResponseEntity.ok(service.create(dto));
	}
	
	// atualizar
	@PutMapping("/{id}")
	public ResponseEntity<ContatoDTO> update(@PathVariable Long id, @RequestBody ContatoDTO dto) {
		logger.info("🖥 Contato atualizado com sucesso!");
		return ResponseEntity.ok(service.update(id, dto));
	}
	
	// deletar
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		logger.info("🖥 Contato removido com sucesso!");
		return ResponseEntity.noContent().build();
	}
}
