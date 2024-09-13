package com.exemple.brista.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.exemple.brista.entity.Comentario;
import com.exemple.brista.entity.PontoRoteiro;
import com.exemple.brista.entity.Roteiro;
import com.exemple.brista.entity.user.User;
import com.exemple.brista.service.ComentarioService;
import com.exemple.brista.service.PontoRoteiroService;
import com.exemple.brista.service.RoteiroService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/brazu/pontos")
public class PontoRoteiroController {

	    private final  PontoRoteiroService pontoRoteiroService;
	    private final ComentarioService comentarioService;
	    
	    @Autowired
	    private RoteiroService roteiroService;

	    public PontoRoteiroController(PontoRoteiroService pontoRoteiroService, ComentarioService comentarioService) {
	        this.pontoRoteiroService = pontoRoteiroService;
	        this.comentarioService = comentarioService;
	    }


	    @PostMapping("/roteiro")
	    public ResponseEntity<Roteiro> criarRoteiro(
	            @RequestBody List<Long> pontoTuristicoIds, 
	            @AuthenticationPrincipal User user) {

	        // Cria uma nova instância de Roteiro e associa o usuário autenticado
	        Roteiro roteiro = new Roteiro();
	        roteiro.setUser(user);

	        // Tenta buscar e associar os pontos turísticos ao roteiro
	        List<PontoRoteiro> pontosTuristicos = new ArrayList<>();
	        
	        for (Long pontoRoteiroId : pontoTuristicoIds) {
	            Optional<PontoRoteiro> pontoRoteiroOpt = pontoRoteiroService.findById(pontoRoteiroId);
	            
	            if (pontoRoteiroOpt.isPresent()) {
	                PontoRoteiro pontoRoteiro = pontoRoteiroOpt.get();
	                pontoRoteiro.setRoteiro(roteiro);  // Associa o ponto turístico ao roteiro
	                pontosTuristicos.add(pontoRoteiro);
	            } else {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 se o ponto não for encontrado
	            }
	        }

	        // Associa os pontos turísticos ao roteiro
	        roteiro.setPontosTuristicos(pontosTuristicos);
	        

	        // Salva o roteiro com os pontos turísticos associados
	        Roteiro savedRoteiro = roteiroService.save(roteiro);
	        System.out.println("salvo " + roteiro);

	        return new ResponseEntity<>(savedRoteiro, HttpStatus.CREATED);
	    }
	 
	    
	    @PostMapping("/{pontoRoteiroId}/comentarios")
	    public ResponseEntity<Comentario> addComentario(
	            @PathVariable Long pontoRoteiroId,
	            @RequestBody Comentario comentario,
	            @AuthenticationPrincipal User user) { 

	        Optional<PontoRoteiro> pontoRoteiroOpt = pontoRoteiroService.findById(pontoRoteiroId);

	        if (pontoRoteiroOpt.isPresent()) {
	            PontoRoteiro pontoRoteiro = pontoRoteiroOpt.get();
	            comentario.setPontoRoteiro(pontoRoteiro);  // Associa o comentário ao ponto de roteiro
	            comentario.setUser(user);  // Associa o comentário ao usuário autenticado
	            Comentario savedComentario = comentarioService.save(comentario);
	            return new ResponseEntity<>(savedComentario, HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    
	    // Endpoint para listar os comentários de um ponto de roteiro
	    @GetMapping("/{pontoRoteiroId}/comentarios")
	    public ResponseEntity<List<Comentario>> getComentariosByPontoRoteiro(@PathVariable Long pontoRoteiroId) {
	        List<Comentario> comentarios = comentarioService.findByPontoRoteiroId(pontoRoteiroId);
	        return new ResponseEntity<>(comentarios, HttpStatus.OK);
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
