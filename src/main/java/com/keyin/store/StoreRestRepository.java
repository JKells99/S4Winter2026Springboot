package com.keyin.store;

import com.keyin.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRestRepository extends JpaRepository<Store, Long> {
    Store getStoreByStoreName(String storeName);
    Optional<Store> findStoreByStoreNameAndCity(String storeName, City city);
}
