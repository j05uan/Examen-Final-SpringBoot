package modelo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class Modelo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column( columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @NotBlank
    @Column( columnDefinition = "VARCHAR(200)", nullable = false)
    private String descripcion;

}
