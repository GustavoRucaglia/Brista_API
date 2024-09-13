package com.exemple.brista.entity;

import java.util.List;
import java.util.Optional;

import com.exemple.brista.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "roteiro")
@Entity(name = "roteiro")
public class Roteiro {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToMany(mappedBy = "roteiro", cascade = CascadeType.ALL, fetch = FetchType.LAZY,  orphanRemoval = true)
	    private List<PontoRoteiro> pontosTuristicos;
	    

	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false)
	    @JsonIgnore
	    private User user;
	    
	    

		public Roteiro() {

		}
	    
		public Roteiro(Long id, List<PontoRoteiro> pontosTuristicos, User user) {
			super();
			this.id = id;
			this.pontosTuristicos = pontosTuristicos;
			this.user = user;
		}
		
		public Roteiro(Long id, List<PontoRoteiro> pontosTuristicos) {
			super();
			this.id = id;
			this.pontosTuristicos = pontosTuristicos;
		}
		
		public Roteiro(List<PontoRoteiro> pontosTuristicos) {
			super();
			this.pontosTuristicos = pontosTuristicos;
		}

		
		
		public Long getId() {
			return id;
		}
		
		
		
		public void setId(Long id) {
			this.id = id;
		}

		public List<PontoRoteiro> getPontosTuristicos() {
			return pontosTuristicos;
		}

		public void setPontosTuristicos(List<PontoRoteiro> pontosTuristicos) {
			 System.out.println("Método setPontosTuristicos chamado com: " + pontosTuristicos);
			this.pontosTuristicos = pontosTuristicos;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	    
	    

}
