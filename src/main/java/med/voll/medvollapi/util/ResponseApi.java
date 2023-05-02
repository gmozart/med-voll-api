package med.voll.medvollapi.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.medvollapi.entity.Consulta;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseApi {

    private Consulta consulta;

    public static ResponseApi of(Consulta consulta) {
        return ResponseApi.builder()
                .consulta(consulta)
                .build();
    }
}
