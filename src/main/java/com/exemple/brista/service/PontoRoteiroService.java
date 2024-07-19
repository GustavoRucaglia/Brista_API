package com.exemple.brista.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.exemple.brista.entity.PontoRoteiro;
import com.exemple.brista.repository.PontoRoteiroRepository;

@Service
public class PontoRoteiroService {
	private final PontoRoteiroRepository pontoRoteiroRepository;

    public  PontoRoteiroService( PontoRoteiroRepository  PontoRoteiroRepository) {
        this.pontoRoteiroRepository =  PontoRoteiroRepository;
    }
    
    public List<PontoRoteiro> findAll(String sortField) {
        Sort sort = Sort.by(sortField).descending();
        return pontoRoteiroRepository.findAll(sort);
    }
    
    public Optional<PontoRoteiro> findById(Long id) {
        return  pontoRoteiroRepository.findById(id);
    }

    public  PontoRoteiro save( PontoRoteiro  pontoRoteiro) {
        return  pontoRoteiroRepository.save(pontoRoteiro);
    }

    public void deleteById(Long id) {
    	 pontoRoteiroRepository.deleteById(id);
    }
}
