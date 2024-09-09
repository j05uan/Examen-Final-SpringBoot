package modelo.application;

import java.util.List;
import java.util.Optional;

import modelo.domain.entity.Modelo;

public interface IModeloService {

    Optional<Modelo> findByID(long id);
    List<Modelo> getAll();
    Modelo save(Modelo modelo);
    void deleteById(long id);
    
}
