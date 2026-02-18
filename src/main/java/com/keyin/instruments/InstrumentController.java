package com.keyin.instruments;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/instrument")
public class InstrumentController {

    @Autowired
    private  InstrumentService instrumentService;

    @GetMapping("/test")
    public String testEndpoint() {
        return "Hello from the InstrumentController!";
    }


    @GetMapping
    public Iterable<Instrument> getAllInstruments(){
        return instrumentService.getAllInstruments();
    }

    @PostMapping
    public Instrument createInstrument(@RequestBody Instrument instrument){
        return instrumentService.createInstrument(instrument);
    }

    @GetMapping("/{id}")
    public Optional<Instrument> findInstrumentById(@PathVariable Long id){
        return instrumentService.findByInstrumentById(id);
    }

    @GetMapping("/type/{instrumentType}")
    public Iterable<Instrument> getInstrumentsByType(@PathVariable String instrumentType) {
        return instrumentService.getInstrumentsByType(instrumentType);

    }



}
