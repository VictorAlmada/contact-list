package com.victor.contact_list.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContatoDTO {
	
	Long id;
	String nome;
	String telefone;
	String email;
	
	
}
