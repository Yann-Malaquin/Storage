package fr.yannm.backend.respository;

import fr.yannm.backend.model.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Yann
 * @version 1.0
 * @name : StorageRepository
 * @created 24/02/2022 - 14:19
 * @project backend
 * @copyright Yann
 **/
@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

    Optional<Storage> findBySlug(String slug);

    Boolean existsBySlug(String slug);

}
