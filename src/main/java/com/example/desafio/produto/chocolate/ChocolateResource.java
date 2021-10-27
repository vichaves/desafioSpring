package com.example.desafio.produto.chocolate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chocolates")
public class ChocolateResource {

    @Autowired
    ChocolateService chocolateService;

    @GetMapping({"", "/"})
    public ResponseEntity<Iterable<Chocolate>> getAllChocolate() {
        return ResponseEntity.ok(chocolateService.getAll());
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable Long id) {
        return ResponseEntity.of(chocolateService.getById(id));
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Chocolate> createChocolate(@RequestBody Chocolate chocolate) {
        return ResponseEntity.ok(chocolateService.save(chocolate));
    }

}
