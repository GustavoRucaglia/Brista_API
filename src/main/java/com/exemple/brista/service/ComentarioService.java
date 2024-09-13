package com.exemple.brista.service;
	import java.util.List;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

import com.exemple.brista.entity.Comentario;
import com.exemple.brista.repository.ComentariosRepository;

	@Service
	@Transactional
	public class ComentarioService{

	    private final ComentariosRepository comentarioRepository;

	    public ComentarioService(ComentariosRepository comentarioRepository) {
	        this.comentarioRepository = comentarioRepository;
	    }

	    public Comentario save(Comentario comentario) {
	        return comentarioRepository.save(comentario);
	    }

	    public List<Comentario> findByPontoRoteiroId(Long pontoRoteiroId) {
	        return comentarioRepository.findByPontoRoteiroId(pontoRoteiroId);
	    }

	    public void deleteById(Long id) {
	        comentarioRepository.deleteById(id);
	    }
	}