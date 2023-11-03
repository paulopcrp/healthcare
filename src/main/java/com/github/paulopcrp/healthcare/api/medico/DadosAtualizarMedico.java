package com.github.paulopcrp.healthcare.api.medico;

import com.github.paulopcrp.healthcare.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(

        @NotNull
        Long id,
        String email,
        String telefone,
        DadosEndereco endereco) {
}
