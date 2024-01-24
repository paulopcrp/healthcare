package com.github.paulopcrp.healthcare.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.paulopcrp.healthcare.api.domain.medico.Especialidade;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        Long idMedico,

        @NotNull
        Long idPaciente,

        @Column(name="data")
        @NotNull
        @Future
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime data,

        Especialidade especialidade) {
}
