package bicicletas.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bicicletas.domain.entity.Bicicletas;

@Repository
public interface IBicicletaRepository extends JpaRepository<Bicicletas,Long>{

}
