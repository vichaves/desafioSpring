package com.example.desafio.produto.presente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.produto.ProdutoService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoResource {

    @Autowired private ProdutoService produtoService;
    
    @GetMapping
    public ResponseEntity<?> getRelatorio() {
    	return new ResponseEntity<>(produtoService.getTop10Notas(), HttpStatus.OK);
    }
}
