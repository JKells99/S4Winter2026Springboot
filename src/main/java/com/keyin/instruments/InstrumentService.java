package com.keyin.instruments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstrumentService {

    @Autowired
    private InstrumentRestRepository instrumentRestRepository;

    public Iterable<Instrument> getAllInstruments(){
        return instrumentRestRepository.findAll();
    }
    public Instrument createInstrument(Instrument instrument){
        return instrumentRestRepository.save(instrument);
    }

    public Optional<Instrument> findByInstrumentById(Long id) {
        return instrumentRestRepository.findById(id);
    }

    public Iterable<Instrument> getInstrumentsByType(String instrumentType) {
        return instrumentRestRepository.getInstrumentsByInstrumentType(instrumentType);
    }
}
