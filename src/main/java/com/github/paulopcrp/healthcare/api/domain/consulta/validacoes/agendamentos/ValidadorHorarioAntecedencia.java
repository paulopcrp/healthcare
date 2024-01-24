package com.github.paulopcrp.healthcare.api.domain.consulta.validacoes.agendamentos;

import com.github.paulopcrp.healthcare.api.domain.ValidacaoException;
import com.github.paulopcrp.healthcare.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendanda com antecedência minina de 30 minutos!");
        }
    }
}
