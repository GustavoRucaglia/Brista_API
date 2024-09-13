package com.exemple.brista.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.brista.entity.Comentario;


public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

	List<Comentario> findByPontoRoteiroId(Long pontoRoteiroId);

}
