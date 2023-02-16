package service;

import dto.MedicoDTO;
import entity.Medico;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import repository.MedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;


    public void save(MedicoDTO medico){
      log.info("Criando um novo médico!");
      medicoRepository.save(MedicoDTO.of(medico));
    }

    public Optional<MedicoDTO> findByid(Long id){
        log.info("Buscar e retornar médico por id!");
        return MedicoDTO.of(medicoRepository.findById(id));
    }

    public Page<MedicoDTO> findAllPages(Integer page, Integer size){
        log.info("Retornar uma página de médicos.");
        return new PageImpl<>(MedicoDTO.of(medicoRepository.findAll()), PageRequest.of(page,size),size);
    }

    public Optional<List<MedicoDTO>> findAll(){
        return Optional.of(MedicoDTO.of(medicoRepository.findAll()));
    }

    public Optional<MedicoDTO> update(Long id, MedicoDTO medico){
     medico.setId(id);
     return Optional.of(MedicoDTO.of(medicoRepository.save(MedicoDTO.of(medico))));
    }

    public void delete(Long id){
        medicoRepository.deleteById(id);
    }
}