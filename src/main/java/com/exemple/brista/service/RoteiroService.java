package com.exemple.brista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.exemple.brista.entity.Roteiro;
import com.exemple.brista.entity.user.User;
import com.exemple.brista.repository.PontoRoteiroRepository;
import com.exemple.brista.repository.RoteiroRepository;
import com.exemple.brista.repository.UserRepository;

@Service
public class RoteiroService {

	    @Autowired
	    private RoteiroRepository roteiroRepository;

	    @Autowired
	    private UserRepository usuarioRepository;

	    // Salva um novo Roteiro
	    public Roteiro save(Roteiro roteiro) {
	        return roteiroRepository.save(roteiro);
	    }

	    // Busca todos os roteiros
	    public List<Roteiro> findAll() {
	        return roteiroRepository.findAll();
	    }

	    // Busca um Roteiro por ID
	    public Roteiro findById(Long id) {
	        return roteiroRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Roteiro não encontrado"));
	    }

	    // Atualiza um Roteiro existente
	    public Roteiro update(Long id, Roteiro roteiroAtualizado, String username) {
	        return roteiroRepository.findById(id).map(roteiro -> {
	            UserDetails usuarioAtivo = usuarioRepository.findByLogin(username);
	            if (usuarioAtivo == null || !roteiro.getUser().equals(usuarioAtivo)) {
	                throw new RuntimeException("Ação não permitida para este usuário");
	            }

	            // Atualiza os campos do Roteiro
	            roteiro.setPontosTuristicos(roteiroAtualizado.getPontosTuristicos());
	            roteiro.setPontosTuristicos(roteiroAtualizado.getPontosTuristicos());

	            return roteiroRepository.save(roteiro);
	        }).orElseThrow(() -> new RuntimeException("Roteiro não encontrado"));
	    }

	    // Deleta um Roteiro por ID
	    public boolean delete(Long id, String username) {
	        return roteiroRepository.findById(id).map(roteiro -> {
	            UserDetails usuarioAtivo = usuarioRepository.findByLogin(username);
	            if (usuarioAtivo == null || !roteiro.getUser().equals(usuarioAtivo)) {
	                throw new RuntimeException("Ação não permitida para este usuário");
	            }

	            roteiroRepository.delete(roteiro);
	            return true;
	        }).orElseThrow(() -> new RuntimeException("Roteiro não encontrado"));
	    }

	    // Busca roteiros pelo ID do usuário
	
	}

