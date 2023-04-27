package med.voll.medvollapi.service.agendamentoconsulta.service;


import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.entity.Consulta;
import med.voll.medvollapi.entity.Medico;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.ConsultaRepository;
import med.voll.medvollapi.repository.MedicoRepository;
import med.voll.medvollapi.repository.PacienteRepository;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultas;
import med.voll.medvollapi.transaction.response.DadosAgendamentoConsulta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    private final MedicoRepository medicoRepository;

    private final PacienteRepository pacienteRepository;

    private final List<ValidadorAgendamentoConsultas> validadores;

    public void agendarConsulta(DadosAgendamentoConsulta dadosAgendamentoConsulta){

        if(!pacienteRepository.existsById(dadosAgendamentoConsulta.idPaciente())){
            throw new ValidacaoException("Id do paciente informado não existe!");
        }
        if (dadosAgendamentoConsulta.idMedico() != null && !medicoRepository.existsById(dadosAgendamentoConsulta.idMedico())){
            throw new ValidacaoException("Id do médico informado não existe!");
        }

        validadores.forEach(validadorConsultas -> validadorConsultas.validar(dadosAgendamentoConsulta));

        var pacienteId = pacienteRepository.getReferenceById(dadosAgendamentoConsulta.idPaciente());
        var medicoLivre = escolherMedico(dadosAgendamentoConsulta);
        var consulta = new Consulta(null, medicoLivre, pacienteId, dadosAgendamentoConsulta.data());
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dadosAgendamentoConsulta){
        if(dadosAgendamentoConsulta.idMedico() != null){
            return medicoRepository.getReferenceById(dadosAgendamentoConsulta.idMedico());
        }
        if(dadosAgendamentoConsulta.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatória quando o médico não for escolhido");
        }
        return medicoRepository.escolherMedicoLivreNaData(dadosAgendamentoConsulta.especialidade(), dadosAgendamentoConsulta.data());
    }

}