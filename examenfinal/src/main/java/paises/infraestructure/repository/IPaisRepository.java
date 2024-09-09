package paises.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import paises.domain.entity.Pais;

@Repository
public interface IPaisRepository extends JpaRepository<Pais,Long>{

}
