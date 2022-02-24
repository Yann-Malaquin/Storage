package fr.yannm.backend.respository;

import fr.yannm.backend.model.product.Product;
import fr.yannm.backend.model.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Yann
 * @version 1.0
 * @name : ProductRepository
 * @created 24/02/2022 - 14:18
 * @project backend
 * @copyright Yann
 **/
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findBySlug(String slug);

    List<Product> findProductsByStorage(Storage storage);

}
