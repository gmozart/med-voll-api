package med.voll.medvollapi.controller;

import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.dto.PacienteDTO;
import med.voll.medvollapi.entity.Paciente;
import med.voll.medvollapi.exception.MdvNotFoundException;
import med.voll.medvollapi.service.PacienteService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    @Transactional
    public ResponseEntity<PacienteDTO> save(@Valid @RequestBody PacienteDTO pacienteDTO){
        pacienteService.save(pacienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.findById(id).orElseThrow(MdvNotFoundException::new));
    }

    @GetMapping
    public  ResponseEntity<List<PacienteDTO>> findAll(){
        return ResponseEntity.ok(pacienteService.findAll().orElseThrow(MdvNotFoundException::new));
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> findPage(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok(pacienteService.findPage(page,size));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteDTO> update(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO){
        return ResponseEntity.ok(pacienteService.update(id, pacienteDTO).orElseThrow(MdvNotFoundException::new));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteDTO> delete(@PathVariable Long id){
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}