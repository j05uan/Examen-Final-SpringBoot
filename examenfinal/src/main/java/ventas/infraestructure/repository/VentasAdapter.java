package ventas.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ventas.application.IVentaService;
import ventas.domain.entity.Ventas;

@Service
public class VentasAdapter implements IVentaService{

    @Autowired
    private IVentasRepository iVentasRepository;

    @Override
    public Optional<Ventas> findByID(long id){
        return iVentasRepository.findById(id);
    }

    @Override
    public List<Ventas> getAll(){
        return iVentasRepository.findAll();
    }

    @Override
    public Ventas save(Ventas ventas){
        return iVentasRepository.save(ventas);
    }

    @Override
    public void deleteById(long id){
        iVentasRepository.deleteById(id);
    }

}
