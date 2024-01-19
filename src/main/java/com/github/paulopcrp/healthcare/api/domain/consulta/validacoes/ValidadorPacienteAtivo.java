package com.github.paulopcrp.healthcare.api.domain.consulta.validacoes;

import com.github.paulopcrp.healthcare.api.domain.ValidacaoException;
import com.github.paulopcrp.healthcare.api.domain.consulta.DadosAgendamentoConsulta;
import com.github.paulopcrp.healthcare.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo!");
        }
    }
}
