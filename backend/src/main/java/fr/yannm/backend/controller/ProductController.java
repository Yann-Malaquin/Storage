package fr.yannm.backend.controller;

import fr.yannm.backend.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yann
 * @version 1.0
 * @name : ProductController
 * @created 25/02/2022 - 15:16
 * @project backend
 * @copyright Yann
 **/
@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("productById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("productBySlug/{slug}")
    public ResponseEntity<?> getProductById(@PathVariable("slug") String slug) {
        return productService.getProductBySlug(slug);
    }

    @GetMapping("productByStorage/{id}")
    public ResponseEntity<?> getProductByStorage(@PathVariable("id") Long id) {
        return productService.getProductsByStorage(id);
    }
}
