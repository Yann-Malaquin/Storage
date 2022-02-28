package fr.yannm.backend.controller;

import fr.yannm.backend.model.storage.CreateStorage;
import fr.yannm.backend.model.storage.UpdateStorage;
import fr.yannm.backend.service.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yann
 * @version 1.0
 * @name : StorageController
 * @created 25/02/2022 - 14:57
 * @project backend
 * @copyright Yann
 **/
@CrossOrigin
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("storages")
    public ResponseEntity<?> getStorages() {
        return storageService.getStorages();
    }

    @GetMapping("storageById/{id}")
    public ResponseEntity<?> getStorageById(@PathVariable("id") Long id) {
        return storageService.getStorageById(id);
    }

    @GetMapping("storageBySlug/{slug}")
    public ResponseEntity<?> getStorageBySlug(@PathVariable("slug") String slug) {
        return storageService.getStorageBySlug(slug);
    }

    @PostMapping("newStorage")
    public ResponseEntity<?> newStorage(@Validated @RequestBody CreateStorage createStorage) {
        return storageService.createStorage(createStorage);
    }

    @PutMapping("updateStorageById/{id}")
    public ResponseEntity<?> updateStorageById(@PathVariable("id") Long id,
                                               @Validated @RequestBody UpdateStorage updateStorage) {
        return storageService.updateStorageById(id, updateStorage);
    }

    @DeleteMapping("deleteStorageById/{id}")
    public ResponseEntity<?> deleteStorageById(@PathVariable("id") Long id) {
        return storageService.deleteStorageById(id);
    }

}
