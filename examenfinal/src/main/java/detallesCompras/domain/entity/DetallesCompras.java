package detallesCompras.domain.entity;

import compras.domain.entity.Compras;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import repuestos.domain.entity.Repuestos;

@Getter
@Setter
@Builder
@Entity
public class DetallesCompras {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn( name = "compra_id")
    private Compras compra;

    @ManyToOne
    @JoinColumn( name = "repuesto_id")
    private Repuestos repuesto;

    @NotBlank
    @Column( columnDefinition = "INT", nullable = false)
    private int cantidad;

    @NotBlank
    @Column ( columnDefinition = "DECIMAL(10,2)", nullable = false)
    private int precioUnitario;

}
