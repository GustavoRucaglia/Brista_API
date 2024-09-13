package com.exemple.brista.entity.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.exemple.brista.entity.Comentario;
import com.exemple.brista.entity.Roteiro;

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

@Table(name = "USERS")
@Entity(name = "USERS")
public class User implements UserDetails{


	 @Id
	 @GeneratedValue(strategy = GenerationType.UUID)
	private String id;
    
	private String login;
	public String username;
	private String password;
	private String photo;
	private UserRole role;
	
	  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios = new ArrayList<>();
	
	  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Roteiro roteiro;
	
	public User(String id, String login, String password, UserRole role, String username) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
		this.username = username;
	}
	
	
	
	public User(String id, String login, String username, String password, String photo, UserRole role,
			List<Comentario> comentarios, Roteiro roteiro) {
		super();
		this.id = id;
		this.login = login;
		this.username = username;
		this.password = password;
		this.photo = " ";
		this.role = role;
		this.comentarios = comentarios;
		this.roteiro = roteiro;
	}



	public User(String login, String password, UserRole role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	
	public User() {
		
	}

	
	public User(String id, String login, String password, UserRole role, List<Comentario> comentarios) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
		this.comentarios = comentarios;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}
	
	
	
	public void setUsername(String username) {
		this.username = username;
	}

	public Roteiro getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}

	
	
	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserRole getRole() {
		return role;
	}
	
	public void setRole(UserRole role) {
		this.role = role;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER") );
		else return  List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	@Override
	public String getUsername() {
		
		return login;
	}

}
