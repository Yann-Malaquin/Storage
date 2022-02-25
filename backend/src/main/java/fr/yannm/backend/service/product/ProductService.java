package fr.yannm.backend.service.product;

import fr.yannm.backend.respository.ProductRepository;
import fr.yannm.backend.respository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Yann
 * @version 1.0
 * @name : ProductService
 * @created 24/02/2022 - 14:33
 * @project backend
 * @copyright Yann
 **/
@Service
public class ProductService implements ProductServiceItf {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public ResponseEntity<?> getProductById(Long id) {

        if (productRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(productRepository.findById(id));
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product does not exist !");
    }

    @Override
    public ResponseEntity<?> getProductBySlug(String slug) {
        if (productRepository.existsBySlug(slug)) {
            return ResponseEntity.status(HttpStatus.OK).body(productRepository.findBySlug(slug));
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product does not exist !");
    }

    @Override
    public ResponseEntity<?> getProductsByStorage(Long id) {
        if (storageRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(storageRepository.findById(id).get().getProductList());
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Storage does not exist");
    }
}
