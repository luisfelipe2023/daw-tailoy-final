package pe.edu.cibertec.examen_final.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class InventarioService {
    @CircuitBreaker(name = "inventarioService", fallbackMethod = "fallbackErrorInventario")
    public String verificarProductoReposicion(Long productId) {

        if (productId > 10) {
            throw new RuntimeException("Simulando un fallo para probar el fallback");
        }
        return "Producto ID " + productId + " disponible, no es necesario reponer.";
    }

    public String fallbackErrorInventario(Long productId , Throwable t) {
        return "No se pudo verificar o reponer el inventario para el producto ID: "
                + productId + ". Por favor, verifique manualmente.";
    }

}
