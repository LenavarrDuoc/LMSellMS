package cl.duoc.lmsellms.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Descuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double porcentajeDcto;


    private LocalDate fechaCreacion;


    private LocalDate fechaModificacion;

    private LocalDate fechaExpiracion;

    @PrePersist
    protected void fechaOnCreate(){
        this.fechaCreacion = LocalDate.now();
        this.fechaModificacion = LocalDate.now();
    }

    @PreUpdate
    protected void fechaOnUpdate(){
        this.fechaModificacion = LocalDate.now();
    }
}
