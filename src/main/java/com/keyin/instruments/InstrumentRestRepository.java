package com.keyin.instruments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentRestRepository extends JpaRepository< Instrument, Long> {


    List<Instrument> getInstrumentsByInstrumentType(String instrumentType);
}
