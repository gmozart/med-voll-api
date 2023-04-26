package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;

import med.voll.medvollapi.repository.ValidadorAgendamentoConsultas;
import med.voll.medvollapi.transaction.response.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioFuncionamentoClinica implements ValidadorAgendamentoConsultas {

   public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta){

       var inicioHorarioClinica = 7;
       var fimHorarioClinica= 18;

       var dataConsulta = dadosAgendamentoConsulta.data();
       var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
       var antesAberturaClinica = dataConsulta.getHour() < inicioHorarioClinica;
       var depoisEncerramentoClinica = dataConsulta.getHour() > fimHorarioClinica;

       if(domingo || antesAberturaClinica || depoisEncerramentoClinica){
           throw new RuntimeException("Consulta fora do horário de funcionamento da clinica!");
       }
   }
}