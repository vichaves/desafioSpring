package com.example.desafio.produto.presente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PresenteService {

    @Autowired private PresenteRepository presenteRepository;
    
    public Presente create(Presente presente) {
    	if(Objects.nonNull(presente.getId())) {
    		throw new RuntimeException("Presente não pode ter ID");
    	} 
    	return presenteRepository.save(presente);
    }
    
    public List<Presente> getAll() {
    	final List<Presente> presentesList = new ArrayList<>();
    	presenteRepository.findAll().forEach(presentesList::add);
    	return presentesList;
    }
    
    public Presente getById(Long id) {
    	return presenteRepository.findById(id)
    			.orElseThrow(() -> new RuntimeException("Presente not found"));
    }
    
    public Presente update(Presente presente) {
    	if(Objects.isNull(presente.getId())) {
    		throw new RuntimeException("Presente precisa ter ID");
    	}
    	return presenteRepository.save(presente);
    }
    
    public void delete(Long id) {
    	presenteRepository.deleteById(id);
    }
    
    public Iterable<Presente> saveAll(Iterable<Presente> presentes) {
        return presenteRepository.saveAll(presentes);
    }
}
