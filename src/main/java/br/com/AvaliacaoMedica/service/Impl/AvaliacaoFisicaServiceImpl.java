package br.com.AvaliacaoMedica.service.Impl;

import br.com.AvaliacaoMedica.entity.Paciente;
import br.com.AvaliacaoMedica.entity.AvaliacaoFisica;
import br.com.AvaliacaoMedica.entity.form.AvaliacaoFisicaForm;
import br.com.AvaliacaoMedica.entity.form.AvaliacaoFisicaUpdateForm;
import br.com.AvaliacaoMedica.repository.PacienteRepository;
import br.com.AvaliacaoMedica.repository.AvaliacaoFisicaRepository;
import br.com.AvaliacaoMedica.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private PacienteRepository PacienteRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Paciente Paciente = PacienteRepository.findById(form.getPacienteId()).get();

        avaliacaoFisica.setPaciente(Paciente);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return null;
    }

    @Override
    public List<AvaliacaoFisica> getAll() {

        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisicaUpdate = new AvaliacaoFisica();
        avaliacaoFisicaUpdate.setPeso(formUpdate.getPeso());
        avaliacaoFisicaUpdate.setAltura(formUpdate.getAltura());
        return avaliacaoFisicaUpdate;
    }

    @Override
    public void delete(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}




