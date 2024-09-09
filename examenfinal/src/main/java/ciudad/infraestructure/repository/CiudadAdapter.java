package ciudad.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciudad.application.ICiudadService;
import ciudad.domain.entity.Ciudad;

@Service
public class CiudadAdapter implements ICiudadService {

    @Autowired
    private ICiudadRepository iCiudadRepository;

    @Override
    public Optional<Ciudad> findByID(long id){
        return iCiudadRepository.findById(id);
    }

    @Override
    public List<Ciudad> getAll(){
        return iCiudadRepository.findAll();
    }

    @Override
    public Ciudad save(Ciudad ciudad){
        return iCiudadRepository.save(ciudad);
    }

    @Override
    public void deleteById(long id){
        iCiudadRepository.deleteById(id);
    }


}
