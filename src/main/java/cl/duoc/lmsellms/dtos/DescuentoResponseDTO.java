package cl.duoc.lmsellms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescuentoResponseDTO {

    private Long id;
    private String nombre;
    private Double porcentajeDcto;
    private LocalDate fechaExpiracion;
}
