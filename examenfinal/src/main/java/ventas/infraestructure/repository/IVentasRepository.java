package ventas.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ventas.domain.entity.Ventas;

@Repository
public interface IVentasRepository extends JpaRepository<Ventas,Long>{

}
