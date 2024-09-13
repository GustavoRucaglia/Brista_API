package com.exemple.brista.entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Table( name = "ponto_roteiro")
@Entity( name = "ponto_roteiro")
public class PontoRoteiro {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;  
    
    @Column(nullable = false)
    private String nome;
    
    @Column(name = "descricao", length = 10000)
    private String descricao;

    @Column(nullable = false)
    private Double nota;

    @Column(nullable = true, updatable = false)
    private LocalDateTime dataDeCriacao;

    @Column(nullable = true)
    private String latitude;
    
    @Column(nullable = true)
    private String categoria;
    
    @Column(nullable = true)
    private String longitude;
    
    @Column(nullable = true)
    private String  fotos;
    
    @Column(nullable = true)
    private boolean state;
    
    @OneToMany(mappedBy = "pontoRoteiro", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "roteiro_id")
    @JsonIgnore
    private Roteiro roteiro;


    // Construtores, getters e setters

    public PontoRoteiro() {
    	this.dataDeCriacao = LocalDateTime.now();
        this.state = true;
    }

	public PontoRoteiro(Long id, String nome, String descricao, Double nota, LocalDateTime dataDeCriacao,
			String latitude, String categoria, String longitude, String fotos, boolean state) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.nota = nota;
		this.dataDeCriacao = dataDeCriacao;
		this.latitude = latitude;
		this.categoria = categoria;
		this.longitude = longitude;
		this.fotos = fotos;
		this.state = state;
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
    
    

    public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Roteiro getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}

	public void setState(boolean state) {
		this.state = state;
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
    

	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
