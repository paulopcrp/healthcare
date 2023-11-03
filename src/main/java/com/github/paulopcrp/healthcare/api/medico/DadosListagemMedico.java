package com.github.paulopcrp.healthcare.api.medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade, String telefone) {

    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(),medico.getTelefone());
    }
}
