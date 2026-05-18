package cl.duoc.lmsellms.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaInputDTO {

   private Long carritoId;
   private Long descuentoId;
   private Long direccionId;

}
