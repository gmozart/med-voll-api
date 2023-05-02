package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;


import med.voll.medvollapi.dto.ConsultaDTO;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultasRepository;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioFuncionamentoClinica implements ValidadorAgendamentoConsultasRepository {

   public void validar(ConsultaDTO dadosAgendamentoConsulta){

       var inicioHorarioClinica = 7;
       var fimHorarioClinica= 18;

       var dataConsulta = dadosAgendamentoConsulta.getData();
       var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
       var antesAberturaClinica = dataConsulta.getHour() < inicioHorarioClinica;
       var depoisEncerramentoClinica = dataConsulta.getHour() > fimHorarioClinica;

       if(domingo || antesAberturaClinica || depoisEncerramentoClinica){
           throw new RuntimeException("Consulta fora do horário de funcionamento da clinica!");
       }
   }
}