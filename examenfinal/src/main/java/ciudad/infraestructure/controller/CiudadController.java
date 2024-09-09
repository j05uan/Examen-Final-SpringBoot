package ciudad.infraestructure.controller;

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

import ciudad.application.ICiudadService;
import ciudad.domain.entity.Ciudad;

@RestController
@RequestMapping("/campusbike/ciudad")
public class CiudadController {

    @Autowired
    private ICiudadService iCiudadService;

    @GetMapping
    public List<Ciudad> list(){
        return iCiudadService.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> show(@PathVariable Long id) {
        Optional<Ciudad> ciudad = iCiudadService.findByID(id);
        return ciudad.map( c -> new ResponseEntity<>(c, HttpStatus.OK))
            .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Ciudad> create(@RequestBody Ciudad ciudad) {

        iCiudadService.save(ciudad);
        return new ResponseEntity<>(ciudad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> update(@PathVariable Long id,
            @RequestBody Ciudad ciudad) {

            Ciudad ciudadUser = iCiudadService.save( ciudad);
        return new ResponseEntity<>(ciudadUser, HttpStatus.OK);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (iCiudadService.findByID(id).isPresent()) {
            iCiudadService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
