package com.example.desafio.produto.chocolate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChocolateRepository extends CrudRepository<Chocolate, Long> {
}
