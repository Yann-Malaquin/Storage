package fr.yannm.backend.service.product;

import fr.yannm.backend.model.product.CreateProduct;
import fr.yannm.backend.model.product.Product;
import fr.yannm.backend.model.product.UpdateProduct;
import fr.yannm.backend.model.storage.CreateStorage;
import fr.yannm.backend.model.storage.Storage;
import fr.yannm.backend.model.storage.UpdateStorage;
import fr.yannm.backend.respository.ProductRepository;
import fr.yannm.backend.respository.StorageRepository;
import fr.yannm.backend.utility.Slug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public ResponseEntity<?> createProduct(CreateProduct createProduct) {

        if (productRepository.existsByName(createProduct.getName())) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product already exists !");
        }

        Optional<Storage> storageOptional = storageRepository.findById(createProduct.getStorageId());
        Storage storage = null;

        if (!storageOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Storage does not exist");
        } else {
            storage = storageOptional.get();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(new Product(
                createProduct.getName(),
                createProduct.getQuantity(),
                storage
        )));

    }

    @Override
    public ResponseEntity<?> updateProductById(Long id,
                                               UpdateProduct updateProduct) {


        Optional<Product> productOptional = productRepository.findById(id);
        Product productToUpdate = null;

        if (!productRepository.findByName(updateProduct.getName()).equals(productOptional)) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product already exists !");
        }

        Optional<Storage> storageOptional = null;

        if (updateProduct.getStorageId() != null) {
            storageOptional = storageRepository.findById(updateProduct.getStorageId());
        }

        Storage storageToUpdate = null;

        if (productOptional.isPresent()) {

            productToUpdate = productOptional.get();

            productToUpdate.setName(updateProduct.getName());
            productToUpdate.setSlug(Slug.makeSlug(updateProduct.getName()));

            productToUpdate.setQuantity(updateProduct.getQuantity());

            storageToUpdate = storageOptional.get();
            productToUpdate.setStorage(storageToUpdate);

            return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productToUpdate));
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product does not exist !");
    }

    @Override
    public ResponseEntity<?> deleteProductById(Long id) {

        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            productRepository.delete(productOptional.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product does not exist !");
    }


}
