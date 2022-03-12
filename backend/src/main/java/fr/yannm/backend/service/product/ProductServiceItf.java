package fr.yannm.backend.service.product;

import fr.yannm.backend.model.product.CreateProduct;
import fr.yannm.backend.model.product.UpdateProduct;
import fr.yannm.backend.model.storage.CreateStorage;
import fr.yannm.backend.model.storage.UpdateStorage;
import org.springframework.http.ResponseEntity;

/**
 * @author Yann
 * @version 1.0
 * @name : ProductServiceItf
 * @created 24/02/2022 - 14:33
 * @project backend
 * @copyright Yann
 **/
public interface ProductServiceItf {

    public ResponseEntity<?> getProductById(Long id);

    public ResponseEntity<?> getProductBySlug(String slug);

    public ResponseEntity<?> getProductsByStorage(Long id);

    public ResponseEntity<?> createProduct(CreateProduct createProduct);

    public ResponseEntity<?> updateProductById(Long id, UpdateProduct updateProduct);

    public ResponseEntity<?> deleteProductById(Long id);

}
