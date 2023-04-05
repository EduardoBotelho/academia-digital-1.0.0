package br.com.AvaliacaoMedica.repository;

import br.com.AvaliacaoMedica.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {


    @Query(value = "SELECT * FROM tb_matriculas m INNER JOIN tb_Pacientes a ON m.Paciente_id = a.id " +
            "WHERE a.bairro = :bairro", nativeQuery = true)


    List<Matricula> findPacientesMatriculadosBairro(String bairro);
}
