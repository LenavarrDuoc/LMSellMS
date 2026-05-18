package cl.duoc.lmsellms.dtos;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescuentoInputDTO {

    @NotBlank
    private String nombre;

    @PositiveOrZero
    private Double porcentajeDcto;

    private LocalDate fechaExpiracion;

    @AssertTrue(message = "Fecha expiracion no valida. Debe ser al menos 1 día superior a la fecha actual.")
    public boolean isFechaExpiracionValid() {

        return (fechaExpiracion != null && fechaExpiracion.isAfter(LocalDate.now()));

    }
}
