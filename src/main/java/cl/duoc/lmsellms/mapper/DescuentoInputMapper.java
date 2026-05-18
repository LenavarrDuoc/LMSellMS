package cl.duoc.lmsellms.mapper;

import cl.duoc.lmsellms.dtos.DescuentoInputDTO;
import cl.duoc.lmsellms.models.Descuento;
import org.springframework.stereotype.Component;

@Component
public class DescuentoInputMapper {

    public Descuento toEntity(DescuentoInputDTO dto){
        if (dto != null){
            Descuento ent = new Descuento();

            ent.setNombre(dto.getNombre());
            ent.setPorcentajeDcto(dto.getPorcentajeDcto());
            ent.setFechaExpiracion(dto.getFechaExpiracion());
            return ent;
        }
        return null;

    }
}
