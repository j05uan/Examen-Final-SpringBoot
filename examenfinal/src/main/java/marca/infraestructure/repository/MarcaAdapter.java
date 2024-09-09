package marca.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marca.application.IMarcaService;
import marca.domain.entity.Marca;

@Service
public class MarcaAdapter implements IMarcaService {

    @Autowired
    private  IMarcaRepository marcaRepository;

    @Override
    public Optional<Marca> findByID(long id){
        return marcaRepository.findById(id);
    }

    @Override
    public List<Marca> getAll(){
        return marcaRepository.findAll();
    }

    @Override
    public Marca save(Marca marca){
        return marcaRepository.save(marca);
    }

    @Override
    public void deleteById(long id){
        marcaRepository.deleteById(id);
    }

}
