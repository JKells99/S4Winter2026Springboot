package com.keyin.store;

import com.keyin.city.City;
import com.keyin.city.CityRestRepository;
import com.keyin.employee.Employee;
import com.keyin.employee.EmployeeRestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StoreServiceTest {

    @Mock
    private StoreRestRepository storeRestRepository;

    @Mock
    private CityRestRepository cityRestRepository;

    @Mock
    private EmployeeRestRepository employeeRestRepository;

    @InjectMocks
    private StoreService storeService;

    private Store store;
    private City city;
    private Employee employee;

    @BeforeEach
    public void setup() {
        city = new City("St. John's");
        city.setCityId(1L);

        store = new Store("Music Store 1", "123 Main St", city);
        store.setStoreId(1L);

        employee = new Employee("John", "Doe", "Manager");
        employee.setEmployeeId(1L);
    }

    @Test
    public void testGetAllStores() {
        Store store2 = new Store("Music Store 2", "456 Water St", new City("Mount Pearl"));
        List<Store> storeList = List.of(store, store2);

        Mockito.when(storeRestRepository.findAll()).thenReturn(storeList);

        Iterable<Store> returnedStores = storeService.getAllStores();

        List<Store> resultList = new ArrayList<>();
        returnedStores.forEach(resultList::add);

        Assertions.assertEquals(2, resultList.size());
        Assertions.assertTrue(resultList.contains(store));
    }

    @Test
    public void testCreateStore_CityExists() {
        Mockito.when(cityRestRepository.findCityByCityName(city.getCityName())).thenReturn(Optional.of(city));
        Mockito.when(storeRestRepository.findStoreByStoreNameAndCity(store.getStoreName(), city)).thenReturn(Optional.empty());
        Mockito.when(storeRestRepository.save(store)).thenReturn(store);

        Store createdStore = storeService.createStore(store);

        Assertions.assertNotNull(createdStore);
        Assertions.assertEquals(city, createdStore.getCity());
        Mockito.verify(storeRestRepository).save(store);
    }

    @Test
    public void testCreateStore_NewCity() {
        City newCity = new City("Gander");
        Store newStore = new Store("Gander Music", "11 Airport Blvd", newCity);

        Mockito.when(cityRestRepository.findCityByCityName("Gander")).thenReturn(Optional.empty());
        Mockito.when(cityRestRepository.save(newCity)).thenReturn(newCity);
        Mockito.when(storeRestRepository.findStoreByStoreNameAndCity("Gander Music", newCity)).thenReturn(Optional.empty());
        Mockito.when(storeRestRepository.save(newStore)).thenReturn(newStore);

        Store createdStore = storeService.createStore(newStore);

        Assertions.assertNotNull(createdStore);
        Mockito.verify(cityRestRepository).save(newCity);
        Mockito.verify(storeRestRepository).save(newStore);
    }

    @Test
    public void testAddEmployeeToStore() {
        Mockito.when(storeRestRepository.findById(1L)).thenReturn(Optional.of(store));
        Mockito.when(employeeRestRepository.findById(1L)).thenReturn(Optional.of(employee));
        Mockito.when(storeRestRepository.save(store)).thenReturn(store);

        Optional<Store> updatedStore = storeService.addEmployeeToStore(1L, 1L);

        Assertions.assertTrue(updatedStore.isPresent());
        Assertions.assertTrue(updatedStore.get().getEmployees().contains(employee));
    }
}
