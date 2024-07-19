package com.exemple.brista.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.brista.entity.PontoRoteiro;


public interface PontoRoteiroRepository extends JpaRepository<PontoRoteiro, Long> {
	
}
