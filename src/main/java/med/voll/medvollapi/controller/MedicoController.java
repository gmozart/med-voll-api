package med.voll.medvollapi.controller;

import med.voll.medvollapi.dto.MedicoDTO;
import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.exception.MdvNotFoundException;
import med.voll.medvollapi.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<MedicoDTO> save(@Valid @RequestBody MedicoDTO medicoDTO, UriComponentsBuilder uriBuilder){
        medicoService.save(medicoDTO);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medicoDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(medicoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(medicoService.findByid(id).orElseThrow(MdvNotFoundException::new));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MedicoDTO>> findAll(){
        return ResponseEntity.ok(medicoService.findAll().orElseThrow(MdvNotFoundException::new));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoDTO>> findPage(@RequestParam Integer page, @RequestParam Integer size){
        return  ResponseEntity.ok(medicoService.findAllPages(page, size));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<MedicoDTO> update(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO){
        return ResponseEntity.ok(medicoService.update(id,medicoDTO).orElseThrow(MdvNotFoundException::new));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<MedicoDTO> delete (@PathVariable Long id){
        medicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}