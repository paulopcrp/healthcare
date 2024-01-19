package com.github.paulopcrp.healthcare.api.domain.consulta.validacoes;

import com.github.paulopcrp.healthcare.api.domain.ValidacaoException;
import com.github.paulopcrp.healthcare.api.domain.consulta.ConsultaRepository;
import com.github.paulopcrp.healthcare.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorPacienteSemOutraConsultaNoDia {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("Paciente já possui uma consulta agendada neste dia e horario.");
        }
    }
}
