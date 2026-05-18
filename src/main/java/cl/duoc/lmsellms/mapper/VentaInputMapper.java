package cl.duoc.lmsellms.mapper;

import cl.duoc.lmsellms.dtos.DetalleOrderResponseDTO;
import cl.duoc.lmsellms.dtos.DireccionResponseDTO;
import cl.duoc.lmsellms.dtos.VentaInputDTO;
import cl.duoc.lmsellms.models.Descuento;
import cl.duoc.lmsellms.models.Venta;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VentaInputMapper {

    private final ObjectMapper objectMapper; //Mapeador de objetos

    // Según consejo de Gemini: Spring inyectará el ObjectMapper configurado automáticamente
    public VentaInputMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public Venta toEntity(Long clienteId, String clienteNombre, String clienteRun, List<DetalleOrderResponseDTO> detallesVenta, DireccionResponseDTO direccion, Double total, Descuento descuento, VentaInputDTO dto){

        if (dto == null) return null;
        Venta ent = new Venta();
        ent.setClienteId(clienteId);
        ent.setClienteNombre(clienteNombre);
        ent.setClienteRun(clienteRun);
        ent.setCarritoId(dto.getCarritoId());
        // Convertimos la lista a un String plano de forma segura
        try {
            String longTextDetalles = objectMapper.writeValueAsString(detallesVenta);
            ent.setDetallesVenta(longTextDetalles);
        } catch (Exception e) {
            ent.setDetallesVenta("[]"); // Fallback en caso de error de parsing
        }
        ent.setDireccionId(dto.getDireccionId());
        String nroDeptoStr = (direccion.getNroDepto() == null || direccion.getNroDepto() == 0) ? "" : ", " + direccion.getNroDepto();
        String direccionEnvio = direccion.getCalle() + " #" + direccion.getNumero() + nroDeptoStr + ", " + direccion.getComuna() + ", " + direccion.getRegion();
        ent.setDireccionEnvio(direccionEnvio);
        ent.setTotal(total);
        ent.setDescuento(descuento);
        ent.aplicarDescuento(descuento);
        ent.setRealizada(false);

        return ent;
    }

}
