package med.voll.medvollapi.repository;


import med.voll.medvollapi.transaction.response.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoConsultas {

    void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta);

}