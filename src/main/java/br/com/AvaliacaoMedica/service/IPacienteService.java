package br.com.AvaliacaoMedica.service;

import br.com.AvaliacaoMedica.entity.Paciente;
import br.com.AvaliacaoMedica.entity.AvaliacaoFisica;
import br.com.AvaliacaoMedica.entity.form.PacienteUpdateForm;
import br.com.AvaliacaoMedica.entity.form.PacienteForm;

import java.util.List;

public interface IPacienteService {
  /**
   * Cria um Paciente e salva no banco de dados.
   * @param form - formulário referente aos dados para criação de um Paciente no banco de dados.
   * @return - Paciente recém-criado.
   */
  Paciente create(PacienteForm form);

  /**
   * Retorna um Paciente que está no banco de dados de acordo com seu Id.
   * @param id - id do Paciente que será exibido.
   * @return - Paciente de acordo com o Id fornecido.
   */
  Paciente get(Long id);

  /**
   * Retorna todos os Pacientes que estão no banco de dados.
   * @return - Uma lista os Pacientes que estão salvas no DB.
   */
  List<Paciente> getAll(String dataDeNascimento);

  /**
   * Atualiza o Paciente.
   * @param id - id do Paciente que será atualizado.
   * @param formUpdate - formulário referente aos dados necessários para atualização do Paciente
   * no banco de dados.
   * @return - Paciente recém-atualizado.
   */
  Paciente update(Long id, PacienteUpdateForm formUpdate);

  /**
   * Deleta um Paciente específico.
   * @param id - id do Paciente que será removido.
   */
  void delete(Long id);

  List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);
}
