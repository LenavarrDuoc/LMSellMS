package cl.duoc.lmsellms.clients;


import cl.duoc.lmsellms.dtos.ClienteOrderResponseDTO;
import cl.duoc.lmsellms.dtos.DireccionResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// APIName = LMCustomerMS;
// APIURL original sin Eureka y Gateway = "http://localhost:8082/clientes";

@FeignClient(name = "LMCustomerMS", path = "/api/v1")
public interface ToAPICustomerFeign {

    @GetMapping("/clientes/{id}")
    ClienteOrderResponseDTO findById(@PathVariable Long id);

    @GetMapping("/clientes/exists-by-id/{id}")
    Boolean existsById(@PathVariable Long id);

    @GetMapping("/direcciones/{id}")
    DireccionResponseDTO findDireccionById(@PathVariable Long id);
}


