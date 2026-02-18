package com.keyin.instruments;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instrumentId;

    private String instrumentName;

    private String instrumentType;

    public Instrument(String instrumentName, String instrumentType) {
        this.instrumentName = instrumentName;
        this.instrumentType = instrumentType;
    }

    public Instrument(Long instrumentId, String instrumentName, String instrumentType) {
        this.instrumentId = instrumentId;
        this.instrumentName = instrumentName;
        this.instrumentType = instrumentType;
    }

    public Instrument() {
    }

    public Long getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Long instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }
}
