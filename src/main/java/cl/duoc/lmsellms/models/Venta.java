package cl.duoc.lmsellms.models;


import com.fasterxml.jackson.annotation.JsonRawValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private String clienteNombre;
    private String clienteRun;
    private Long carritoId;
    @Column(name = "detalles_venta", columnDefinition = "LONGTEXT") //Convierte todos los detalles por separado en un solo texto plano tipo LONGTEXT.
    @JsonRawValue //Devuelve los detalles de texto plano como un JSON
    private String detallesVenta;
    private Long direccionId;
    private String direccionEnvio;
    private Double total;
    @ManyToOne
    @JoinColumn(name =  "descuento_id", nullable = false)
    private Descuento descuento;
    private Double totalFinal;
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;
    private LocalDate fechaSalida;
    private Boolean realizada;

    public void aplicarDescuento(Descuento descuento){
        this.totalFinal =  Math.floor(this.total * (1 - descuento.getPorcentajeDcto()));
    }
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