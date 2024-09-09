package modelo.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.application.IModeloService;
import modelo.domain.entity.Modelo;

@Service
public class ModeloAdapter implements IModeloService {

    @Autowired
    private IModeloRepository iModeloRepository;

    @Override
    public Optional<Modelo> findByID(long id){
        return iModeloRepository.findById(id);
    }

    @Override
    public List<Modelo> getAll(){
        return iModeloRepository.findAll();
    }

    @Override
    public Modelo save(Modelo modelo){
        return iModeloRepository.save(modelo);
    }

    @Override
    public void deleteById(long id){
        iModeloRepository.deleteById(id);
    }


}
