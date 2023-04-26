package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;

import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultas;
import med.voll.medvollapi.transaction.response.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioAntecedencia implements ValidadorAgendamentoConsultas {

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaMinutos = Duration.between(dataConsulta,agora).toMinutes();

        if(diferencaMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedência  mínima de 30 minutos");
        }


    }


}
