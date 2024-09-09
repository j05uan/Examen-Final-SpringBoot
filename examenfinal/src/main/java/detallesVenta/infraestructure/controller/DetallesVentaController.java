package detallesVenta.infraestructure.controller;

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

import detallesVenta.application.IDetallesVentaService;
import detallesVenta.domain.entity.DetallesVenta;

@RestController
@RequestMapping("/campusbike/detallesVenta")
public class DetallesVentaController {

    @Autowired
    private IDetallesVentaService iDetallesVentaService;

    @GetMapping
    public List<DetallesVenta> list(){
        return iDetallesVentaService.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DetallesVenta> show(@PathVariable Long id) {
        Optional<DetallesVenta> detalleVenta = iDetallesVentaService.findByID(id);
        return detalleVenta.map( c -> new ResponseEntity<>(c, HttpStatus.OK))
            .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DetallesVenta> create(@RequestBody DetallesVenta detalleVenta) {

        iDetallesVentaService.save(detalleVenta);
        return new ResponseEntity<>(detalleVenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallesVenta> update(@PathVariable Long id,
            @RequestBody DetallesVenta detalleVenta) {

            DetallesVenta detalleVentaUser = iDetallesVentaService.save( detalleVenta);
        return new ResponseEntity<>(detalleVentaUser, HttpStatus.OK);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (iDetallesVentaService.findByID(id).isPresent()) {
            iDetallesVentaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
