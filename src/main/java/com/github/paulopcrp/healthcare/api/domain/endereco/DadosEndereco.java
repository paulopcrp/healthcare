package com.github.paulopcrp.healthcare.api.domain.endereco;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @Embedded
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        String complemento,
        String numero) {
}
