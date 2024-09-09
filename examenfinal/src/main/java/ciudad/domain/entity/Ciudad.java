package ciudad.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import paises.domain.entity.Pais;

@Setter
@Getter
@Entity
@Table( name = "ciudades")
public class Ciudad {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column( columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

}
