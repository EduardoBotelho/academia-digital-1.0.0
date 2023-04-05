package br.com.AvaliacaoMedica.repository;

import br.com.AvaliacaoMedica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {


    List<Paciente> findByDataDeNascimento(LocalDate dataDeNascimento);
}
