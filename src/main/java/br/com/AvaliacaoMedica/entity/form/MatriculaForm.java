package br.com.AvaliacaoMedica.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaForm {

  @NotNull(message = "Preencha corretamente o campo.")
  @Positive(message = "O id do Paciente precisa ser positivo.")
  private Long PacienteId;

}
