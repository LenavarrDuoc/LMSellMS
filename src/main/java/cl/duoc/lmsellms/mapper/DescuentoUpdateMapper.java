package cl.duoc.lmsellms.mapper;

import cl.duoc.lmsellms.dtos.DescuentoUpdateDTO;
import cl.duoc.lmsellms.models.Descuento;
import org.springframework.stereotype.Component;

@Component
public class DescuentoUpdateMapper {

    public Descuento toEntity(Descuento ent, DescuentoUpdateDTO dto){
        if (dto != null){


            ent.setId(dto.getId());
            ent.setNombre(dto.getNombre());
            ent.setPorcentajeDcto(dto.getPorcentajeDcto());
            ent.setFechaExpiracion(dto.getFechaExpiracion());
            return ent;
        }
        return null;

    }
}
