package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;


import med.voll.medvollapi.dto.ConsultaDTO;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultasRepository;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioAntecedencia implements ValidadorAgendamentoConsultasRepository {

    public void validar(ConsultaDTO dadosAgendamentoConsulta){

//        var tempoAntecedencia = 30;
//        var dataConsulta = dadosAgendamentoConsulta.getData();
//        var agora = LocalDateTime.now();
//        var diferencaMinutos = Duration.between(dataConsulta,agora).toMinutes();
//
//        if(diferencaMinutos < tempoAntecedencia){
//            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
//        }


    }


}
