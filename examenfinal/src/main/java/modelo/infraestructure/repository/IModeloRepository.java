package modelo.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modelo.domain.entity.Modelo;

@Repository
public interface IModeloRepository extends JpaRepository<Modelo, Long> {

}
