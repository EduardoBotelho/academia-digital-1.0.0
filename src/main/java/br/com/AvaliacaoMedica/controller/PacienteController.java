package br.com.AvaliacaoMedica.controller;

import br.com.AvaliacaoMedica.entity.Paciente;
import br.com.AvaliacaoMedica.entity.AvaliacaoFisica;
import br.com.AvaliacaoMedica.service.Impl.PacienteServiceImpl;
import br.com.AvaliacaoMedica.entity.form.PacienteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl service;

    @PostMapping
    public Paciente create(@Valid @RequestBody PacienteForm form) {
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<Paciente> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                      String dataDeNascimento){
        return service.getAll(dataDeNascimento);
    }


}
