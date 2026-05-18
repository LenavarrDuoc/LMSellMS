package cl.duoc.lmsellms.repositories;

import cl.duoc.lmsellms.models.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento, Long> {
    boolean existsByNombre(String nombre);

    Descuento findByNombre(String nombre);
}
