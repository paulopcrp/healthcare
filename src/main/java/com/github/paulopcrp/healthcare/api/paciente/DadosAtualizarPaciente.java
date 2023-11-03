package com.github.paulopcrp.healthcare.api.paciente;

import com.github.paulopcrp.healthcare.api.endereco.DadosEndereco;
import jakarta.validation.Valid;

public record DadosAtualizarPaciente(
    Long id,
    String nome,
    String telefone,
    @Valid DadosEndereco endereco
    ) {
}
