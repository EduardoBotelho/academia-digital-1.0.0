package me.dio.academia.digital.Impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
        private AvaliacaoFisicaRepository AvaliacaoFisicarepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

       return AvaliacaoFisicarepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return null;
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll() {

        return service.getAll();
    }

    @PostMapping
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisicaUpdate = new AvaliacaoFisica();
        avaliacaoFisicaUpdate.setPeso(formUpdate.getPeso());
        avaliacaoFisicaUpdate.setAltura(formUpdate.getAltura());
        return avaliacaoFisicaUpdate;
    }

    @DeleteMapping
    public void delete(Long id) {
        AvaliacaoFisicarepository.deleteById(id);

    }


}
