package com.exemple.brista.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;
import com.exemple.brista.entity.PontoRoteiro;
import com.exemple.brista.service.PontoRoteiroService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brazu/pontos")
public class PontoRoteiroController {

	    private final  PontoRoteiroService pontoRoteiroService;

	    public  PontoRoteiroController( PontoRoteiroService  pontoRoteiroService) {
	        this.pontoRoteiroService =   pontoRoteiroService;
	    }

	    @GetMapping
	    public ResponseEntity<List<PontoRoteiro>> getAllItems(@RequestParam(defaultValue = "dataDeCriacao") String sort) {
	        List<PontoRoteiro> items =  pontoRoteiroService.findAll(sort);
	        return new ResponseEntity<>(items, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<PontoRoteiro> getItemById(@PathVariable Long id) {
	        Optional<PontoRoteiro>  pontoRoteiro =  pontoRoteiroService.findById(id);
	        return  pontoRoteiro.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PostMapping
	    public ResponseEntity<PontoRoteiro> createItem(@RequestBody PontoRoteiro pontoRoteiro) {
	    	PontoRoteiro savedPontoRoteiro = pontoRoteiroService.save(pontoRoteiro);
	        return new ResponseEntity<>(savedPontoRoteiro, HttpStatus.CREATED);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<PontoRoteiro> updateItem(@PathVariable Long id, @RequestBody  PontoRoteiro  pontoRoteiro) {
	        Optional<PontoRoteiro> existingPontoRoteiro =  pontoRoteiroService.findById(id);
	        if (existingPontoRoteiro.isPresent()) {
	        	pontoRoteiro.setId(id);
	        	PontoRoteiro updatedItem = pontoRoteiroService.save(pontoRoteiro);
	            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
	    	pontoRoteiroService.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
