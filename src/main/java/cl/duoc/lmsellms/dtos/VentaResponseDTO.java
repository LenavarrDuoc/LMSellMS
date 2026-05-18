package cl.duoc.lmsellms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaResponseDTO {

    private Long Id;
    private Long clienteId;
    private String clienteNombre;
    private String clienteRun;
    private Double total;
    private String descuento;
    private Double totalFinal;
    private String direccionEnvio;
    private Boolean realizado;
}
