package med.voll.medvollapi.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.dto.ConsultaDTO;
import med.voll.medvollapi.service.agendamentoconsulta.service.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/consulta")
public class AgendamentoConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    public ResponseEntity agendar(@RequestBody @Valid ConsultaDTO dadosConsultaDTO){

        consultaService.agendarConsulta(dadosConsultaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
