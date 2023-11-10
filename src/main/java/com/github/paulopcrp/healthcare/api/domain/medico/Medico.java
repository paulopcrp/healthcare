package com.github.paulopcrp.healthcare.api.domain.medico;

import com.github.paulopcrp.healthcare.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    //private String especialidade; implementar ao final do curso como objeto de estudos

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo ;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());

    }

    public void atualizarInformacoes(DadosAtualizarMedico dadosAtualizarMedico) {
        if (dadosAtualizarMedico.email() != null) {
            this.email = dadosAtualizarMedico.email();
        }

        if (dadosAtualizarMedico.telefone() != null) {
            this.telefone = dadosAtualizarMedico.telefone();
        }

        if (dadosAtualizarMedico.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosAtualizarMedico.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
