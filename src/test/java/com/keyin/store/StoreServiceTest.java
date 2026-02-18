package com.keyin.store;

import com.keyin.city.City;
import com.keyin.city.CityRestRepository;
import com.keyin.employee.Employee;
import com.keyin.employee.EmployeeRestRepository;
import org.junit.jupiter.api.Assertions;
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

    @Test
    public void testGetAllStores() {
        Store store1 = new Store("Music Store 1", "123 Main St", new City("St. John's"));
        Store store2 = new Store("Music Store 2", "456 Water St", new City("Mount Pearl"));
        List<Store> storeList = new ArrayList<>();
        storeList.add(store1);
        storeList.add(store2);

        Mockito.when(storeRestRepository.findAll()).thenReturn(storeList);

        Iterable<Store> returnedStores = storeService.getAllStores();

        Assertions.assertTrue(returnedStores.iterator().hasNext());
        int count = 0;
        for (Store s : returnedStores) {
            count++;
        }
        Assertions.assertEquals(2, count);
    }

    @Test
    public void testCreateStore_CityExists() {
        City existingCity = new City("St. John's");
        existingCity.setCityId(1L);
        Store newStore = new Store("New Store", "789 Broadway", new City("St. John's"));

        Mockito.when(cityRestRepository.findCityByCityName("St. John's")).thenReturn(Optional.of(existingCity));
        Mockito.when(storeRestRepository.findStoreByStoreNameAndCity("New Store", existingCity)).thenReturn(Optional.empty());
        Mockito.when(storeRestRepository.save(newStore)).thenReturn(newStore);

        Store createdStore = storeService.createStore(newStore);

        Assertions.assertNotNull(createdStore);
        Assertions.assertEquals(existingCity, createdStore.getCity());
        Mockito.verify(storeRestRepository, Mockito.times(1)).save(newStore);
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
        Mockito.verify(cityRestRepository, Mockito.times(1)).save(newCity);
        Mockito.verify(storeRestRepository, Mockito.times(1)).save(newStore);
    }

    @Test
    public void testAddEmployeeToStore() {
        Store store = new Store("Test Store", "Address", new City("City"));
        store.setStoreId(1L);
        Employee employee = new Employee("John", "Doe", "Manager");
        employee.setEmployeeId(1L);

        Mockito.when(storeRestRepository.findById(1L)).thenReturn(Optional.of(store));
        Mockito.when(employeeRestRepository.findById(1L)).thenReturn(Optional.of(employee));
        Mockito.when(storeRestRepository.save(store)).thenReturn(store);

        Optional<Store> updatedStore = storeService.addEmployeeToStore(1L, 1L);

        Assertions.assertTrue(updatedStore.isPresent());
        Assertions.assertTrue(updatedStore.get().getEmployees().contains(employee));
    }
}
