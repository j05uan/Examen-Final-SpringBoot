package ciudad.application;

import java.util.List;
import java.util.Optional;

import ciudad.domain.entity.Ciudad;

public interface ICiudadService {

    Optional<Ciudad> findByID(long id);
    List<Ciudad> getAll();
    Ciudad save(Ciudad ciudad);
    void deleteById(long id);

}
