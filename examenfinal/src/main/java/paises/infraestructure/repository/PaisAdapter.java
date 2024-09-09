package paises.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paises.application.IPaisService;
import paises.domain.entity.Pais;

@Service
public class PaisAdapter implements IPaisService{

    @Autowired
    private IPaisRepository iPaisRepository;

    @Override
    public Optional<Pais> findByID(long id){
        return iPaisRepository.findById(id);
    }

    @Override
    public List<Pais> getAll(){
        return iPaisRepository.findAll();
    }

    @Override
    public Pais save(Pais bicicletas){
        return iPaisRepository.save(bicicletas);
    }

    @Override
    public void deleteById(long id){
        iPaisRepository.deleteById(id);
    }

}
