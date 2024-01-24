package com.github.paulopcrp.healthcare.api.domain.consulta.validacoes.agendamentos;

import com.github.paulopcrp.healthcare.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsulta dados);
}
