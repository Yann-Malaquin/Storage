package fr.yannm.backend.controller;

import fr.yannm.backend.model.product.CreateProduct;
import fr.yannm.backend.model.product.UpdateProduct;
import fr.yannm.backend.model.storage.UpdateStorage;
import fr.yannm.backend.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("newProduct")
    public ResponseEntity<?> newProduct(@Validated @RequestBody CreateProduct createProduct) {
        return productService.createProduct(createProduct);
    }

    @PatchMapping("updateProductById/{id}")
    public ResponseEntity<?> updateStorageById(@PathVariable("id") Long id,
                                               @Validated @RequestBody UpdateProduct updateProduct) {
        return productService.updateProductById(id, updateProduct);
    }

    @DeleteMapping("deleteProductById/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") Long id) {
        return productService.deleteProductById(id);
    }
}
