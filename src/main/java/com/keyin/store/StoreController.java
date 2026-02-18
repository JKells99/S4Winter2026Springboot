package com.keyin.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public Iterable<Store> getAllStores(){
        return storeService.getAllStores();
    }

    @PostMapping
    public Store createStore(@RequestBody Store store){
        return storeService.createStore(store);
    }

    @GetMapping("/{id}")
    public Optional<Store> findStoreById(@PathVariable Long id){
        return storeService.findStoreById(id);
    }

    @GetMapping("/name/{storeName}")
    public Store getStoreByStoreName(@PathVariable String storeName){
        return storeService.getStoreByStoreName(storeName);
    }

    @PutMapping("/{storeId}/add-employee/{employeeId}")
    public ResponseEntity<Store> addEmployeeToStore(@PathVariable Long storeId, @PathVariable Long employeeId) {
        Optional<Store> updatedStore = storeService.addEmployeeToStore(storeId, employeeId);
        return updatedStore.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
