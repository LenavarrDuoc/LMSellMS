package cl.duoc.lmsellms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaUpdateDTO {

    private Long id;
    private Long descuentoId;
    private Long direccionId;
}
