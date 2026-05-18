package cl.duoc.lmsellms.mapper;

import cl.duoc.lmsellms.dtos.VentaUpdateOnCloseDTO;
import cl.duoc.lmsellms.models.Venta;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class VentaUpdateOnCloseMapper {

    public Venta toEntity(Venta ent, VentaUpdateOnCloseDTO dto){
        if(dto == null) return null;

        ent.setRealizada(true);
        ent.setFechaSalida(LocalDate.now());
        return ent;

    }
}
