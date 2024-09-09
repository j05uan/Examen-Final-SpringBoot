package clientes.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clientes.application.IClientesService;
import clientes.domain.entity.Clientes;

@RestController
@RequestMapping("/campusbike/cliente")
public class ClienteController {

    @Autowired
    private IClientesService iClientesService;


    @GetMapping
    public List<Clientes> list(){
        return iClientesService.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Clientes> show(@PathVariable Long id) {
        Optional<Clientes> cliente = iClientesService.findByID(id);
        return cliente.map( c -> new ResponseEntity<>(c, HttpStatus.OK))
            .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Clientes> create(@RequestBody Clientes cliente) {

        iClientesService.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> update(@PathVariable Long id,
            @RequestBody Clientes cliente) {

            Clientes clienteUser = iClientesService.save( cliente);
        return new ResponseEntity<>(clienteUser, HttpStatus.OK);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (iClientesService.findByID(id).isPresent()) {
            iClientesService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
