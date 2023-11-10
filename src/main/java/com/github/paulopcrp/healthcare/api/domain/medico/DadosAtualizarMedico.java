package com.github.paulopcrp.healthcare.api.domain.medico;

import com.github.paulopcrp.healthcare.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(

        @NotNull
        Long id,
        String email,
        String telefone,
        DadosEndereco endereco) {
}
