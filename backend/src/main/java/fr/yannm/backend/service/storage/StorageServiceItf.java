package fr.yannm.backend.service.storage;

import fr.yannm.backend.model.storage.CreateStorage;
import fr.yannm.backend.model.storage.UpdateStorage;
import org.springframework.http.ResponseEntity;

/**
 * @author Yann
 * @version 1.0
 * @name : StorageServiceItf
 * @created 25/02/2022 - 14:16
 * @project backend
 * @copyright Yann
 **/
public interface StorageServiceItf {

    public ResponseEntity<?> getStorages();

    public ResponseEntity<?> getStorageById(Long id);

    public ResponseEntity<?> getStorageBySlug(String slug);

    public ResponseEntity<?> createStorage(CreateStorage createStorage);

    public ResponseEntity<?> updateStorageById(Long id, UpdateStorage updateStorage);

    public ResponseEntity<?> deleteStorageById(Long id);

}
