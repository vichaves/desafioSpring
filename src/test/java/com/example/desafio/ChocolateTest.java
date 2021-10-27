package com.example.desafio;

import com.example.desafio.produto.chocolate.Chocolate;
import com.example.desafio.produto.chocolate.ChocolateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ChocolateTest {

    @Autowired private ChocolateService chocolateService;

    /*
    Estes testes unitários irão falhar com as alterações do Desafio 2!
    */

    @Test
    void criacaoChocolate() {
        var chocolate = new Chocolate();

        chocolate.setNome("Bombom ao Leite");
        chocolate.setPeso(0.2);
        chocolate.setPrecoPorQuilograma(9.0);

        chocolateService.save(chocolate);

        assertNotNull(chocolate.getId());
    }

    @Test
    void alteracaoChocolate() {
        var chocolate = new Chocolate();

        chocolate.setNome("Bombom Meio Amargo");
        chocolate.setPeso(0.1);
        chocolate.setPrecoPorQuilograma(10.0);

        chocolateService.save(chocolate);
        var idOriginal = chocolate.getId();

        chocolate.setPrecoPorQuilograma(12.0);

        chocolateService.save(chocolate);

        assertEquals(idOriginal, chocolate.getId());
        assertEquals(12.0, chocolate.getPrecoPorQuilograma());

        var list = chocolateService.getAll();
    }

    @Test
    void notasChocolate() {
        //Gera uma lista contendo 20 chocolates
        var chocolates = IntStream.range(0, 20).mapToObj(i -> {
            var chocolate = new Chocolate();
            chocolate.setNome("Chocolate " + i);
            chocolate.setPeso(0.2);
            chocolate.setPrecoPorQuilograma((i + 1) / 10D);

            //Os últimos chocolates da lista terão as notas mais altas
            chocolate.getNota().add((i + 1) / 20D * 10);

            return chocolate;
        }).collect(Collectors.toList());
        chocolateService.saveAll(chocolates);

        /*
        Este teste unitário pode ser útil para ajudar a resolver o Desafio 3...
         */
    }
}
