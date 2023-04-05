package br.com.AvaliacaoMedica.service.Impl;


import br.com.AvaliacaoMedica.entity.Paciente;
import br.com.AvaliacaoMedica.entity.Matricula;
import br.com.AvaliacaoMedica.entity.form.MatriculaForm;
import br.com.AvaliacaoMedica.repository.PacienteRepository;
import br.com.AvaliacaoMedica.repository.MatriculaRepository;
import br.com.AvaliacaoMedica.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private  MatriculaRepository matriculaRepository;

    @Autowired
    private PacienteRepository PacienteRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Paciente Paciente = PacienteRepository.findById(form.getPacienteId()).get();

        matricula.setPaciente(Paciente);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {

        if(bairro == null){
            return matriculaRepository.findAll();
        }else{
            return matriculaRepository.findPacientesMatriculadosBairro(bairro);
        }

    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }



}