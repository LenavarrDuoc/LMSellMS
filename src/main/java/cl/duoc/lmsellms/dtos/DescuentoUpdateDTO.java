package cl.duoc.lmsellms.dtos;

import cl.duoc.lmsellms.exceptions.FecExpNoValidaException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescuentoUpdateDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String nombre;

    @PositiveOrZero
    private Double porcentajeDcto;

    private LocalDate fechaExpiracion;

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        if (fechaExpiracion != null && fechaExpiracion.isBefore(LocalDate.now().plusDays(1))) {
            throw  new FecExpNoValidaException("Fecha expiracion no valido. Debe ser al menos 1 día superior a la fecha actual.");
        }
        this.fechaExpiracion = fechaExpiracion;
    }
}
