package clientes.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import clientes.domain.entity.Clientes;

@Repository
public interface IClienteRepository extends JpaRepository<Clientes,Long>{

}
