package com.example.desafio.produto.chocolate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ChocolateService {

    @Autowired ChocolateRepository repository;

    public Iterable<Chocolate> getAll() {
        return repository.findAll();
    }

    public Optional<Chocolate> getById(Long id) {
        return repository.findById(id);
    }

    public Chocolate save(Chocolate chocolate) {
        return repository.save(chocolate);
    }

    public Iterable<Chocolate> saveAll(Iterable<Chocolate> chocolates) {
        return repository.saveAll(chocolates);
    }
}
