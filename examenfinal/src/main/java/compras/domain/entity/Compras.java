package compras.domain.entity;

import java.util.Date;

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
import proveedores.domain.entity.Proveedores;

@Getter
@Setter
@Builder
@Entity
public class Compras {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column ( columnDefinition = "DATE", nullable = true)
    private Date fecha;

    @NotBlank
    @Column ( columnDefinition = "DECIMAL(10,2)", nullable = false)
    private String total;

    @ManyToOne
    @JoinColumn( name = "proveedor_id")
    private Proveedores proveedor;


}
