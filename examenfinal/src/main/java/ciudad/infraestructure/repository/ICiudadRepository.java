package ciudad.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ciudad.domain.entity.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad,Long> {

}
