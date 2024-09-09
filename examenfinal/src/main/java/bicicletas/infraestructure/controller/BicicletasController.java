package bicicletas.infraestructure.controller;

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

import bicicletas.application.IBicicletasService;
import bicicletas.domain.entity.Bicicletas;

@RestController
@RequestMapping("campusbike/bicicletas")
public class BicicletasController {

    @Autowired
    private IBicicletasService iBicicletasService;

    @GetMapping
    public List<Bicicletas> list(){
        return iBicicletasService.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Bicicletas> show(@PathVariable Long id) {
        Optional<Bicicletas> bicicleta = iBicicletasService.findByID(id);
        return bicicleta.map( c -> new ResponseEntity<>(c, HttpStatus.OK))
            .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Bicicletas> create(@RequestBody Bicicletas bicicleta) {

        iBicicletasService.save(bicicleta);
        return new ResponseEntity<>(bicicleta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bicicletas> update(@PathVariable Long id,
            @RequestBody Bicicletas bicicleta) {

            Bicicletas bicicletasUSer = iBicicletasService.save( bicicleta);
        return new ResponseEntity<>(bicicletasUSer, HttpStatus.OK);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (iBicicletasService.findByID(id).isPresent()) {
            iBicicletasService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
