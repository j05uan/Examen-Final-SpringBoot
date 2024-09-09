package marca.application;

import java.util.List;
import java.util.Optional;

import marca.domain.entity.Marca;

public interface IMarcaService {

    Optional<Marca> findByID(long id);
    List<Marca> getAll();
    Marca save(Marca marca);
    void deleteById(long id);
    
}
