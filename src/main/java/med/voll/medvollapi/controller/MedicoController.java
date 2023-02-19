package med.voll.medvollapi.controller;

import med.voll.medvollapi.dto.MedicoDTO;
import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoDTO> save(@Valid @RequestBody MedicoDTO medicoDTO){
        medicoService.save(medicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }




}
