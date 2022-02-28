package fr.yannm.backend.service.storage;

import fr.yannm.backend.model.storage.CreateStorage;
import fr.yannm.backend.model.storage.Storage;
import fr.yannm.backend.respository.StorageRepository;
import fr.yannm.backend.utility.Slug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Yann
 * @version 1.0
 * @name : StorageService
 * @created 25/02/2022 - 14:16
 * @project backend
 * @copyright Yann
 **/
@Service
public class StorageService implements StorageServiceItf {

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public ResponseEntity<?> getStorages() {
        if (!storageRepository.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(storageRepository.findAll());
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("StorageList is empty");
    }

    @Override
    public ResponseEntity<?> getStorageById(Long id) {
        if (storageRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(storageRepository.findById(id));
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Storage does not exist !");
    }

    @Override
    public ResponseEntity<?> getStorageBySlug(String slug) {
        if (storageRepository.existsBySlug(slug)) {
            return ResponseEntity.status(HttpStatus.OK).body(storageRepository.findBySlug(slug));
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Storage does not exist !");
    }

    @Override
    public ResponseEntity<?> createStorage(CreateStorage createStorage) {

        if (storageRepository.existsByName(createStorage.getName())) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("Storage already exists !");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(storageRepository.save(new Storage(
                createStorage.getName()
        )));

    }
}
