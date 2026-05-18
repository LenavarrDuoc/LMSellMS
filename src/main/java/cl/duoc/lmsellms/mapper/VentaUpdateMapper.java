package cl.duoc.lmsellms.mapper;

import cl.duoc.lmsellms.dtos.DireccionResponseDTO;
import cl.duoc.lmsellms.dtos.VentaUpdateDTO;
import cl.duoc.lmsellms.models.Descuento;
import cl.duoc.lmsellms.models.Venta;

import org.springframework.stereotype.Component;

@Component
public class VentaUpdateMapper {



    public Venta toEntity(Venta ent, DireccionResponseDTO direccion, Descuento descuento, VentaUpdateDTO dto){

        if (dto == null) return null;

        ent.setDireccionId(dto.getDireccionId());
        ent.setDireccionEnvio(direccion.getCalle() + ", #" + String.valueOf(direccion.getNumero()+ (direccion.getNroDepto() == 0 ? "" : direccion.getNroDepto().toString()) + ", "+  direccion.getComuna() + ", " + direccion.getRegion()));

        ent.setDescuento(descuento);
        ent.aplicarDescuento(descuento);

        return ent;
    }
}
