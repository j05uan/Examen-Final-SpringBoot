package clientes.infraestructure.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clientes.application.IClientesService;
import clientes.domain.entity.Clientes;

@Service
public class ClienteAdapter implements IClientesService {

    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    public Optional<Clientes> findByID(long id){
        return iClienteRepository.findById(id);
    }

    @Override
    public List<Clientes> getAll(){
        return iClienteRepository.findAll();
    }

    @Override
    public Clientes save(Clientes clientes){
        return iClienteRepository.save(clientes);
    }

    @Override
    public void deleteById(long id){
        iClienteRepository.deleteById(id);
    }

}
