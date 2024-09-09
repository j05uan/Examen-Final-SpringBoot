package detallesVenta.infraestructure.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import detallesVenta.domain.entity.DetallesVenta;

@Repository
public interface IDetallesVentaRepositoty extends JpaRepository<DetallesVenta, Long>{

}
