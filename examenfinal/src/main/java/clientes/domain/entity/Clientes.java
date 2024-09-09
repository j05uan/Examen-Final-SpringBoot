package clientes.domain.entity;

import ciudad.domain.entity.Ciudad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Clientes {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;


    @NotBlank
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;
    
    @NotBlank
    @Column(columnDefinition = "BIGINT", nullable = false)
    private int telefono;

    @NotBlank
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String password;


    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;
}
