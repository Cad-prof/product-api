package sn.isi.l3gl.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sn.isi.l3gl.core.entity.Product;
import sn.isi.l3gl.core.service.ProductService;

@RestController                        // Indique que cette classe est un contrôleur REST
@RequestMapping("/api/products")       // Préfixe commun à tous les endpoints
@RequiredArgsConstructor
public class ProductController {

    // On injecte le service venant de product-core
    private final ProductService productService;

    /**
     * POST /api/products
     * Corps (JSON) : { "name": "Stylo", "description": "...", "price": 1.5, "quantity": 10 }
     */
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    /**
     * GET /api/products
     * Retourne la liste de tous les produits
     */
    @GetMapping
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(productService.listProducts());
    }

    /**
     * PUT /api/products/{id}?quantity=10
     * Met à jour la quantité du produit avec l'id donné
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateQuantity(
            @PathVariable Long id,
            @RequestParam Integer quantity) {
        return ResponseEntity.ok(productService.updateQuantity(id, quantity));
    }

    /**
     * GET /api/products/low-stock/count
     * Retourne le nombre de produits avec quantité <= 5
     */
    @GetMapping("/low-stock/count")
    public ResponseEntity<Long> countLowStock() {
        return ResponseEntity.ok(productService.countLowStockProducts());
    }
}