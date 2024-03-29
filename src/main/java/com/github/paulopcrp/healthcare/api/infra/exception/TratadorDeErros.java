package com.github.paulopcrp.healthcare.api.infra.exception;


import com.github.paulopcrp.healthcare.api.domain.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException exception) {
        var erros = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(DadosValidacao::new).toList());

    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity tratarErroRegradeNegocio(ValidacaoException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());

    }

    private record DadosValidacao(String campo, String mensagem){
        public DadosValidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }

    }
}
