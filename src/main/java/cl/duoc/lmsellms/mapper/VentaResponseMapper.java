package cl.duoc.lmsellms.mapper;

import cl.duoc.lmsellms.dtos.VentaResponseDTO;
import cl.duoc.lmsellms.models.Venta;
import org.springframework.stereotype.Component;

@Component
public class VentaResponseMapper {

    public VentaResponseDTO toDto(Venta ent){

        if(ent==null) return null;

        return new VentaResponseDTO(
                ent.getId(),
                ent.getClienteId(),
                ent.getClienteNombre(),
                ent.getClienteRun(),
                ent.getTotal(),
                (String.valueOf((ent.getDescuento().getPorcentajeDcto())*100) + "%"),
                ent.getTotalFinal(),
                ent.getDireccionEnvio(),
                ent.getRealizada()
        );
    }
}
