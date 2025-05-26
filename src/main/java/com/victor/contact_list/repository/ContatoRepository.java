package com.victor.contact_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.contact_list.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
