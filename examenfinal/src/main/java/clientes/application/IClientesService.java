package clientes.application;

import java.util.List;
import java.util.Optional;

import clientes.domain.entity.Clientes;

public interface IClientesService {

    Optional<Clientes> findByID(long id);
    List<Clientes> getAll();
    Clientes save(Clientes clientes);
    void deleteById(long id);

}
