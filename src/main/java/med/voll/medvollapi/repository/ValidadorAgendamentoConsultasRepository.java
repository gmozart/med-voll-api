package med.voll.medvollapi.repository;


import med.voll.medvollapi.dto.ConsultaDTO;

public interface ValidadorAgendamentoConsultasRepository {

    void validar(ConsultaDTO dadosAgendamentoConsulta);

}