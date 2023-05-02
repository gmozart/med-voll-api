package med.voll.medvollapi.service.agendamentoconsulta.service;


import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.dto.ConsultaDTO;
import med.voll.medvollapi.entity.Consulta;
import med.voll.medvollapi.entity.Medico;
import med.voll.medvollapi.entity.Paciente;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.ConsultaRepository;
import med.voll.medvollapi.repository.MedicoRepository;
import med.voll.medvollapi.repository.PacienteRepository;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultasRepository;
import med.voll.medvollapi.util.ResponseApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    private final MedicoRepository medicoRepository;

    private final PacienteRepository pacienteRepository;

    private final List<ValidadorAgendamentoConsultasRepository> validadores;

    public ResponseApi agendarConsulta(ConsultaDTO dadosAgendamentoConsulta){

        Paciente paciente = pacienteRepository.getReferenceById(dadosAgendamentoConsulta.getPacienteId());
        Medico medico = medicoRepository.getReferenceById(dadosAgendamentoConsulta.getMedicoId());

        if(!pacienteRepository.existsById(paciente.getId())){
            throw new ValidacaoException("Id do paciente informado não existe!");
        }
        if (!medicoRepository.existsById(medico.getId())){
            throw new ValidacaoException("Id do médico informado não existe!");
        }

        validadores.forEach(validadorConsultas -> validadorConsultas.validar(dadosAgendamentoConsulta));

        var pacienteId = pacienteRepository.getReferenceById(dadosAgendamentoConsulta.getPacienteId());
        var medicoLivre = escolherMedico(dadosAgendamentoConsulta);
        var consulta = new Consulta(null, medicoLivre, pacienteId, dadosAgendamentoConsulta.getData());


        return ResponseApi.of(consultaRepository.save(consulta));
    }

    private Medico escolherMedico(ConsultaDTO dadosAgendamentoConsulta){

        Medico medico = medicoRepository.getReferenceById(dadosAgendamentoConsulta.getMedicoId());

        if(medico.getId() != null){
            return medicoRepository.getReferenceById(dadosAgendamentoConsulta.getMedicoId());
        }
        if(medico.getEspecialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatória quando o médico não for escolhido");
        }
        return medicoRepository.escolherMedicoLivreNaData(medico.getEspecialidade(), dadosAgendamentoConsulta.getData());
    }

}