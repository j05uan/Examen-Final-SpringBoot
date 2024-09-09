package proveedores.domain.entity;

import ciudad.domain.entity.Ciudad;
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

@Getter
@Setter
@Builder
@Entity
public class Proveedores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @NotBlank
    @Column(columnDefinition = "BIGINT", nullable = false)
    private int contacto;

    @NotBlank
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @NotBlank
    @Column(columnDefinition = "BIGINT", nullable = false)
    private int telefono;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

}
