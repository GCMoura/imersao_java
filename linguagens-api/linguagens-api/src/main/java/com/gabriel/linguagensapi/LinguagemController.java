package com.gabriel.linguagensapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

  @Autowired
  private LinguagemRepository repository;

  // método GET
  @GetMapping(value = "/linguagens")
  public List<Linguagem> obterLinguagem(){
    List<Linguagem> linguagens = repository.findAll();
    return linguagens;
  }
  
  // método POST
  @PostMapping(value = "/linguagens")
  public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem){
    Linguagem linguagemSalva =  repository.save(linguagem);
    return linguagemSalva;
  }

}
