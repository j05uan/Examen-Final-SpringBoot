package repuestos.domain.entity;

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
import marca.domain.entity.Marca;
import modelo.domain.entity.Modelo;
import proveedores.domain.entity.Proveedores;

@Getter
@Setter
@Builder
@Entity
public class Repuestos {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column( columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @NotBlank
    @Column( columnDefinition = "VARCHAR(200)", nullable = false)
    private String descripcion;

    @NotBlank
    @Column ( columnDefinition = "DECIMAL(10,2)", nullable = false)
    private int precio;

    @NotBlank
    @Column( columnDefinition = "INT", nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn( name = "proveedor_id")
    private Proveedores proveedor;

    @ManyToOne
    @JoinColumn( name = "modelo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn( name = "marca")
    private Marca marca;


}
