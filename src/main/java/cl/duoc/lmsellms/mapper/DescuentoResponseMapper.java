package cl.duoc.lmsellms.mapper;

import cl.duoc.lmsellms.dtos.DescuentoResponseDTO;
import cl.duoc.lmsellms.models.Descuento;
import org.springframework.stereotype.Component;

@Component
public class DescuentoResponseMapper {
    public DescuentoResponseDTO toDto (Descuento ent){

        if (ent != null){
        DescuentoResponseDTO dto = new DescuentoResponseDTO();

        dto.setId(ent.getId());
        dto.setNombre(ent.getNombre());
        dto.setPorcentajeDcto(ent.getPorcentajeDcto());
        dto.setFechaExpiracion(ent.getFechaExpiracion());
        return dto;
        }

        return null;
    }

}
