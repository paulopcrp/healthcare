package com.github.paulopcrp.healthcare.api.domain.consulta.validacoes.cancelamentos;

import com.github.paulopcrp.healthcare.api.domain.ValidacaoException;
import com.github.paulopcrp.healthcare.api.domain.consulta.ConsultaRepository;
import com.github.paulopcrp.healthcare.api.domain.consulta.DacosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecedencia implements ValidadorCanvelamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DacosCancelamentoConsulta dados) {

        var consulta = repository.getReferenceById((dados.idConsulta()));
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaEmHoras <24) {
            throw new ValidacaoException("Consulta somente pode ser cancelada com 24 horas de antecedência!");
        }

    }
}
