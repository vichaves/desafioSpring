package com.example.desafio.produto.presente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/presentes")
public class PresenteResource {

    @Autowired private PresenteService presenteService;
    
    @GetMapping
    public ResponseEntity<?> getAll() {
    	return new ResponseEntity<>(presenteService.getAll(), HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
    	return new ResponseEntity<>(presenteService.getById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Presente presente){
    	return new ResponseEntity<>(presenteService.create(presente), HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Presente presente){
    	return new ResponseEntity<>(presenteService.update(presente), HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    	presenteService.delete(id);
    	return ResponseEntity.noContent().build();
    }
}
