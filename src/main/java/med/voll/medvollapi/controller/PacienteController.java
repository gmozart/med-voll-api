package med.voll.medvollapi.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.dto.PacienteDTO;
import med.voll.medvollapi.service.paciente.service.PacienteService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequiredArgsConstructor
@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    @Transactional
    public ResponseEntity<PacienteDTO> save(@RequestBody @Valid PacienteDTO pacienteDTO, UriComponentsBuilder uriBuilder){
        pacienteService.save(pacienteDTO);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(pacienteDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(pacienteDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.findById(id).get());
    }

    @GetMapping("/all")
    public  ResponseEntity<List<PacienteDTO>> findAll(){
        return ResponseEntity.ok(pacienteService.findAll().get());
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> findPage(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok(pacienteService.findPage(page,size));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteDTO> update(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO){
        return ResponseEntity.ok(pacienteService.update(id, pacienteDTO).get());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteDTO> delete(@PathVariable Long id){
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}