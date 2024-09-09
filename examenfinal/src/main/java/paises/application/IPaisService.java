package paises.application;

import java.util.List;
import java.util.Optional;

import paises.domain.entity.Pais;

public interface IPaisService {
    Optional<Pais> findByID(long id);
    List<Pais> getAll();
    Pais save(Pais bicicletas);
    void deleteById(long id);
}
