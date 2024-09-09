package bicicletas.domain.entity;

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
import marca.domain.entity.Marca;
import modelo.domain.entity.Modelo;

@Getter
@Setter
@Entity
public class Bicicletas {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @NotBlank
    @Column ( columnDefinition = "DECIMAL(10,2)", nullable = false)
    private int precio;

    @NotBlank
    @Column( columnDefinition = "INT", nullable = false)
    private int stock;
}
