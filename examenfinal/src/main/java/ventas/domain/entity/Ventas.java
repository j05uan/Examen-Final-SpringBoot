package ventas.domain.entity;

import java.util.Date;

import clientes.domain.entity.Clientes;
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
public class Ventas {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column( columnDefinition = "DATE", nullable = false)
    private Date fecha;

    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

}
