package cl.duoc.lmsellms.mapper;

import cl.duoc.lmsellms.dtos.DescuentoInputDTO;
import cl.duoc.lmsellms.models.Descuento;
import org.springframework.stereotype.Component;

@Component
public class DescuentoInputDTOMapper {

    public Descuento toEntity(DescuentoInputDTO dto){
        Descuento ent = new Descuento();

        ent.setNombre(dto.getNombre());
        ent.setPorcentajeDcto(dto.getPorcentajeDcto());
        ent.setFechaExpiracion(dto.getFechaExpiracion());
        return ent;

    }
}
