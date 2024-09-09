package marca.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import marca.domain.entity.Marca;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Long> {


    
}
