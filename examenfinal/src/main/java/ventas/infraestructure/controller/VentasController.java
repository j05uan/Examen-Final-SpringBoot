package ventas.infraestructure.controller;


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

import ventas.application.IVentaService;
import ventas.domain.entity.Ventas;

@RestController
@RequestMapping("/campusbike/ventas")
public class VentasController {

    @Autowired
    private IVentaService iVentaService;

    @GetMapping
    public List<Ventas> list(){
        return iVentaService.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ventas> show(@PathVariable Long id) {
        Optional<Ventas> Venta = iVentaService.findByID(id);
        return Venta.map( c -> new ResponseEntity<>(c, HttpStatus.OK))
            .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Ventas> create(@RequestBody Ventas Venta) {

        iVentaService.save(Venta);
        return new ResponseEntity<>(Venta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ventas> update(@PathVariable Long id,
            @RequestBody Ventas Venta) {

            Ventas ventaUser = iVentaService.save( Venta);
        return new ResponseEntity<>(ventaUser, HttpStatus.OK);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (iVentaService.findByID(id).isPresent()) {
            iVentaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
