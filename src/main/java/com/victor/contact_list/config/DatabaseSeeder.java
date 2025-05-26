package com.victor.contact_list.config;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.victor.contact_list.model.Contato;
import com.victor.contact_list.model.Role;
import com.victor.contact_list.model.User;
import com.victor.contact_list.repository.ContatoRepository;
import com.victor.contact_list.repository.RoleRepository;
import com.victor.contact_list.repository.UserRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        
        // Criando roles
        Role roleUser = new Role(null, "USER");
        Role roleAdmin = new Role(null, "ADMIN");
        roleRepository.saveAll(List.of(roleUser, roleAdmin));

        // Criando usuários
        User admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles(Set.of(roleAdmin, roleUser))
                .build();

        User user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user123"))
                .roles(Set.of(roleUser))
                .build();

        userRepository.saveAll(List.of(admin, user));

        // Criando contatos
        Contato contato1 = Contato.builder()
        		.nome("João Silva")
        		.telefone("51999999999")
        		.email("joao@email.com")
        		.build();
        
        Contato contato2 = Contato.builder()
        		.nome("Maria Souza")
        		.telefone("51888888888")
        		.email("maria@email.com")
        		.build();
        
        Contato contato3 = Contato.builder()
        		.nome("Carlos Lima")
        		.telefone("51777777777")
        		.email("carlos@email.com")
        		.build();

        contatoRepository.saveAll(List.of(contato1, contato2, contato3));

        System.out.println("🚀 Database seed concluído com sucesso!");
    }
}
