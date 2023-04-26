package med.voll.medvollapi.service.cosulta.service.validacoes;

import med.voll.medvollapi.transaction.response.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class HorarioFuncionamentoClinica {

   public void validar(DadosAgendamentoConsulta dados){

       var dataConsulta = dados.data();
       var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
       var antesAberturaClinica = dataConsulta.getHour() < 7;
       var depoisEncerramentoClinica = dataConsulta.getHour() > 18;

       if(domingo || antesAberturaClinica || depoisEncerramentoClinica){
           throw new RuntimeException("Consulta fora do horário de funcionamento da clinica!");
       }
   }
}