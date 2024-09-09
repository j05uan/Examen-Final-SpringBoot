package bicicletas.application;

import java.util.List;
import java.util.Optional;

import bicicletas.domain.entity.Bicicletas;

public interface IBicicletasService {

    Optional<Bicicletas> findByID(long id);
    List<Bicicletas> getAll();
    Bicicletas save(Bicicletas bicicletas);
    void deleteById(long id);
}
