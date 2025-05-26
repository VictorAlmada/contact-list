package com.victor.contact_list.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.victor.contact_list.dto.ContatoDTO;
import com.victor.contact_list.model.Contato;
import com.victor.contact_list.repository.ContatoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContatoService {
	
	private final ContatoRepository repository;
	
	// mostrar todos
	public List<ContatoDTO> findAll() {
		List<ContatoDTO> list = repository.findAll().stream()
				.map(this::toDTO).collect(Collectors.toList());
		return list;
	}
	
	// buscar por ID
	public ContatoDTO findById(Long id) {
		Contato contato = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contato não encontrado."));
		return toDTO(contato);
	}
	
	// criar
	public ContatoDTO create(ContatoDTO dto) {
		Contato contato = toEntity(dto);
		contato = repository.save(contato);
		return toDTO(contato);
	}
	
	// atualizar
	public ContatoDTO update(Long id, ContatoDTO dto) {
		Contato contato = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contato não encontrado."));
		contato.setNome(dto.getNome());
		contato.setTelefone(dto.getTelefone());
		contato.setEmail(dto.getEmail());
		contato = repository.save(contato);
		return toDTO(contato);
	}
	
	// deletar
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new EntityNotFoundException("Contato não encontrado.");
		}
		repository.deleteById(id);
	}
	
	
	// MÉTODOS PRIVADOS DE CONVERSÃO DTO/ENTITY E ENTITY/DTO
	
	// Converte um Contato para ContatoDTO
	private ContatoDTO toDTO(Contato contato) {
		return ContatoDTO.builder()
				.id(contato.getId())
				.nome(contato.getNome())
				.telefone(contato.getTelefone())
				.email(contato.getEmail())
				.build();
	}
	
	// Converte um ContatoDTO para Contato
	private Contato toEntity(ContatoDTO dto) {
		return Contato.builder()
				.nome(dto.getNome())
				.telefone(dto.getTelefone())
				.email(dto.getEmail())
				.build();
	}
	
}
