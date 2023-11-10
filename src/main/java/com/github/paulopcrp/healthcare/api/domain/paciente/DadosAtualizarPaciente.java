package com.github.paulopcrp.healthcare.api.domain.paciente;

import com.github.paulopcrp.healthcare.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;

public record DadosAtualizarPaciente(
    Long id,
    String nome,
    String telefone,
    @Valid DadosEndereco endereco
    ) {
}
