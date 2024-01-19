package com.github.paulopcrp.healthcare.api.domain.consulta.validacoes;

import com.github.paulopcrp.healthcare.api.domain.ValidacaoException;
import com.github.paulopcrp.healthcare.api.domain.consulta.ConsultaRepository;
import com.github.paulopcrp.healthcare.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada para este horário.");
        }
    }
}
