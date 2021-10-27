package com.example.desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.desafio.produto.presente.Presente;
import com.example.desafio.produto.presente.PresenteService;

@SpringBootTest
class PresenteTest {

    @Autowired private PresenteService presenteService;

    @Test
    void criacaoPresente() {
        var presente = new Presente();
        
        presente.setNome("Presente 1");
        presente.setPreco(3.99);

        presenteService.create(presente);

        assertNotNull(presente.getId());
    }
    
    @Test
    void alteracaoPresente() {
        var presente = new Presente();

        presente.setNome("Presente 2");
        presente.setPreco(3.49);

        presenteService.create(presente);
        var idOriginal = presente.getId();

        presente.setPreco(3.99);

        presenteService.update(presente);

        assertEquals(idOriginal, presente.getId());
        assertEquals(3.99, presente.getPreco());

        var list = presenteService.getAll();
    }

    @Test
    void notasPresente() {
        //Gera uma lista contendo 20 presentes
        var presentes = IntStream.range(0, 20).mapToObj(i -> {
            var presente = new Presente();
            presente.setNome("Presente " + i);
            presente.setPreco((i + 1) / 10D);
            presente.getNota().add((i + 1) / 20D * 10);

            return presente;
        }).collect(Collectors.toList());
        presenteService.saveAll(presentes);
    }
}
