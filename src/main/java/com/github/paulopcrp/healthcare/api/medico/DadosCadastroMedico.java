package com.github.paulopcrp.healthcare.api.medico;

import com.github.paulopcrp.healthcare.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome,
                                  String email,
                                  String crm,
                                  Especialidade especialidade,
                                  DadosEndereco endereco) {
}
