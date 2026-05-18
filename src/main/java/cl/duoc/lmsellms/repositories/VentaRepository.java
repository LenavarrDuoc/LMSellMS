package cl.duoc.lmsellms.repositories;

import cl.duoc.lmsellms.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long> {
    boolean existsByCarritoId(Long carritoId);

    List<Venta> findByClienteRun(String clienteRun);


    List<Venta> findAllByClienteId(Long clienteId);

    List<Venta> findAllByTotalFinal(Double totalFinal);


}
