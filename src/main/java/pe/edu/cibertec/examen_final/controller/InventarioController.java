package pe.edu.cibertec.examen_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.examen_final.service.InventarioService;

@RestController
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/check/{productId}")
    public ResponseEntity<String> verificarInventario(@PathVariable Long productId) {
        return ResponseEntity.ok(inventarioService.verificarProductoReposicion(productId));
    }
}
