package com.github.paulopcrp.healthcare.api.paciente;

import com.github.paulopcrp.healthcare.api.endereco.Endereco;
import com.github.paulopcrp.healthcare.api.medico.DadosDetalhamentoMedico;

public record DadosDetalhamentoPaciente(String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getCpf(),
                paciente.getEndereco());
    }
}
