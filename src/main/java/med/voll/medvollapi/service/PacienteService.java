package med.voll.medvollapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import med.voll.medvollapi.dto.PacienteDTO;
import med.voll.medvollapi.repository.PacienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public void save(PacienteDTO pacienteDTO){
        log.info("Criando um novo paciente!");
        pacienteRepository.save(PacienteDTO.of(pacienteDTO));
    }

    public Optional<PacienteDTO> findById(Long id){
        log.info("Retornando um paciente por seu id!");
        return PacienteDTO.of(pacienteRepository.findById(id));
    }

    public Optional<List<PacienteDTO>> findAll(){
        log.info("Retornando uma lista pacientes!");
        return Optional.of(PacienteDTO.of(pacienteRepository.findAll()));
    }

    public Page<PacienteDTO> findPage(Integer pages, Integer size){
        log.info("Retornando uma página de pacientes!");
        return new PageImpl<>(PacienteDTO.of(pacienteRepository.findAll()), PageRequest.of(pages,size), size);
    }

    public Optional<PacienteDTO> update(Long id, PacienteDTO pacienteDTO){
        pacienteDTO.setId(id);
        log.info("Atualizando os dados de um paciente!");
        return Optional.of(PacienteDTO.of(pacienteRepository.save(PacienteDTO.of(pacienteDTO))));
    }

    public void delete(Long id){
        log.info("Deletando um paciente por seu id!");
        pacienteRepository.deleteById(id);
    }
}