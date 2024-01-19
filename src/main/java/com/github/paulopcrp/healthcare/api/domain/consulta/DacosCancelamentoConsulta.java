package com.github.paulopcrp.healthcare.api.domain.consulta;

import jakarta.validation.constraints.NotNull;
import org.aspectj.weaver.ast.Not;

public record DacosCancelamentoConsulta(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo

) {
}
