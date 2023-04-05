package br.com.AvaliacaoMedica.controller;

import br.com.AvaliacaoMedica.entity.AvaliacaoFisica;
import br.com.AvaliacaoMedica.entity.form.AvaliacaoFisicaForm;
import br.com.AvaliacaoMedica.service.Impl.AvaliacaoFisicaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form){
        return service.create(form);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }
}
