package ventas.application;

import java.util.List;
import java.util.Optional;

import ventas.domain.entity.Ventas;

public interface IVentaService {

    Optional<Ventas> findByID(long id);
    List<Ventas> getAll();
    Ventas save(Ventas ventas);
    void deleteById(long id);


}
