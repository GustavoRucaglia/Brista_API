package com.exemple.brista.entity;

	import java.time.LocalDateTime;

import com.exemple.brista.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.Table;

	@Table(name = "comentarios")
	@Entity(name = "comentario")
	public class Comentario {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String texto;

	    private LocalDateTime dataDeCriacao;

	    @ManyToOne
	    @JoinColumn(name = "ponto_roteiro_id", nullable = false)
	    @JsonIgnore
	    private PontoRoteiro pontoRoteiro;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "user_id", nullable = false)
	    @JsonIgnore
	    private User user;


	    public Comentario() {
	        this.dataDeCriacao = LocalDateTime.now();
	    }

	    public Comentario(String texto, PontoRoteiro pontoRoteiro, User user) {
	        this.texto = texto;
	        this.pontoRoteiro = pontoRoteiro;
	        this.user = user;
	        this.dataDeCriacao = LocalDateTime.now();
	    }
	    
	    public Comentario(String texto) {
	        this.texto = texto;
	        this.dataDeCriacao = LocalDateTime.now();
	    }
	    
	    public Comentario(String texto, PontoRoteiro pontoRoteiro) {
	        this.texto = texto;
	        this.pontoRoteiro = pontoRoteiro;
	        this.dataDeCriacao = LocalDateTime.now();
	    }


	    // Getters e setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getTexto() {
	        return texto;
	    }

	    public void setTexto(String texto) {
	        this.texto = texto;
	    }

	    public LocalDateTime getDataDeCriacao() {
	        return dataDeCriacao;
	    }

	    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
	        this.dataDeCriacao = dataDeCriacao;
	    }

	    public PontoRoteiro getPontoRoteiro() {
	        return pontoRoteiro;
	    }

	    public void setPontoRoteiro(PontoRoteiro pontoRoteiro) {
	        this.pontoRoteiro = pontoRoteiro;
	    }

	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }
	}
