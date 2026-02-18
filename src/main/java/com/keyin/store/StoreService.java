package com.keyin.store;

import com.keyin.city.City;
import com.keyin.city.CityRestRepository;
import com.keyin.city.CityService;
import com.keyin.employee.Employee;
import com.keyin.employee.EmployeeRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRestRepository storeRestRepository;

    @Autowired
    private EmployeeRestRepository employeeRestRepository;

    @Autowired
    private CityRestRepository cityRestRepository;

    public Iterable<Store> getAllStores(){
        return storeRestRepository.findAll();
    }
    public Store createStore(Store store) {
        // Find the city to see if it exists in the db
        Optional<City> cityOptional = cityRestRepository.findCityByCityName(store.getCity().getCityName());
        // If present we will just set the city for store to be the one that comes back from db
        if (cityOptional.isPresent()) {
            store.setCity(cityOptional.get());
        } else {
            // We will save the new city from the passed in city param
            City savedCity = cityRestRepository.save(store.getCity());
            // then we set the city for the store to be the city we just saved
            store.setCity(savedCity);
        }

        // We then check to see if the Store already exist in the city by store name, if it does we return the existing store, if not we save the new store
        Optional<Store> storeOptional = storeRestRepository.findStoreByStoreNameAndCity(store.getStoreName(), store.getCity());
        return storeOptional.orElseGet(() -> storeRestRepository.save(store));


    }

    public Optional<Store> findStoreById(Long id){
        return storeRestRepository.findById(id);
    }
    public Store getStoreByStoreName(String storeName){
        return storeRestRepository.getStoreByStoreName(storeName);
    }

    public Optional<Store> addEmployeeToStore(Long storeId, Long employeeId) {
        Optional<Store> storeOptional = storeRestRepository.findById(storeId);
        Optional<Employee> employeeOptional = employeeRestRepository.findById(employeeId);

        if (storeOptional.isPresent() && employeeOptional.isPresent()) {
            Store store = storeOptional.get();
            Employee employee = employeeOptional.get();
            store.getEmployees().add(employee);
            return Optional.of(storeRestRepository.save(store));
        }
        return Optional.empty();
    }
}
