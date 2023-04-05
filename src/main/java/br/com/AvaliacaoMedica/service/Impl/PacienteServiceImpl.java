package br.com.AvaliacaoMedica.service.Impl;

import br.com.AvaliacaoMedica.infra.utils.JavaTimeUtils;
import br.com.AvaliacaoMedica.entity.Paciente;
import br.com.AvaliacaoMedica.entity.AvaliacaoFisica;
import br.com.AvaliacaoMedica.entity.form.PacienteForm;
import br.com.AvaliacaoMedica.entity.form.PacienteUpdateForm;
import br.com.AvaliacaoMedica.repository.PacienteRepository;
import br.com.AvaliacaoMedica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private PacienteRepository repository;

    @Override
    public Paciente create(PacienteForm form) {
        Paciente Paciente = new Paciente();
        Paciente.setNome(form.getNome());
        Paciente.setCpf(form.getCpf());
        Paciente.setBairro(form.getBairro());
        Paciente.setDataDeNascimento(form.getDataDeNascimento());

        return repository.save(Paciente);
    }

    @Override
    public Paciente get(Long id) {
        return null;
    }

    @Override
    public List<Paciente> getAll(String dataDeNascimento) {

        if(dataDeNascimento == null) {
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localDate);
        }

    }

    @Override
    public Paciente update(Long id, PacienteUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

        Paciente Paciente = repository.findById(id).get();

        return Paciente.getAvaliacoes();

    }

}