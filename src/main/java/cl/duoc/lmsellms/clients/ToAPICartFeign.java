package cl.duoc.lmsellms.clients;

import cl.duoc.lmsellms.dtos.CarritoOrderResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "LMCartMS", path = "/api/v1/carritos")
public interface ToAPICartFeign {
    @GetMapping("/get-cart-for-sell-order/{id}")
    CarritoOrderResponseDTO findByIdForOrder(@PathVariable Long id);
}
