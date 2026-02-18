package com.keyin.store;

import com.keyin.city.City;
import com.keyin.employee.Employee;
import com.keyin.instruments.Instrument;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    private String storeName;
    private String storeAddress;

    @ManyToOne
    private City city;

    @ManyToMany
    private List<Instrument> instruments;

    @OneToMany
    private List<Employee> employees = new ArrayList<>();

    public Store(String storeName, String storeAddress, City city) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.city = city;
        this.instruments = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public Store() {
        this.instruments = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
