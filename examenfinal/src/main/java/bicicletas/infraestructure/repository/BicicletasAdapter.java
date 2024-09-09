package bicicletas.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bicicletas.application.IBicicletasService;
import bicicletas.domain.entity.Bicicletas;

@Service
public class BicicletasAdapter implements IBicicletasService {
     
    @Autowired
    private IBicicletaRepository iBicicletaRepository;

    @Override
    public Optional<Bicicletas> findByID(long id){
        return iBicicletaRepository.findById(id);
    }

    @Override
    public List<Bicicletas> getAll(){
        return iBicicletaRepository.findAll();
    }

    @Override
    public Bicicletas save(Bicicletas bicicletas){
        return iBicicletaRepository.save(bicicletas);
    }

    @Override
    public void deleteById(long id){
        iBicicletaRepository.deleteById(id);
    }

}
