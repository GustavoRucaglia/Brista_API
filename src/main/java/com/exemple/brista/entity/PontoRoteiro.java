package com.exemple.brista.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PontoRoteiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double nota;

    @Column(nullable = true, updatable = false)
    private LocalDateTime dataDeCriacao;

    @Column(nullable = true)
    private String cep;
    
    @Column(nullable = true)
    private String  fotos;
    
    @Column(nullable = true)
    private boolean state;
    

    // Construtores, getters e setters

    public PontoRoteiro() {
    	this.dataDeCriacao = LocalDateTime.now();
        this.state = true;
    }

    public PontoRoteiro(String fotos, String descricao, Double nota, String cep) {
        this.fotos = fotos;
        this.descricao = descricao;
        this.nota = nota;
        this.cep = cep;
        this.dataDeCriacao = LocalDateTime.now();
        this.state = true;
      }

    
    
    
    public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
