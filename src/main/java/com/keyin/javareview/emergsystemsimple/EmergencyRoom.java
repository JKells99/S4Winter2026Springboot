package com.keyin.javareview.emergsystemsimple;

import java.util.ArrayList;
import java.util.List;

public class EmergencyRoom {

    List<Patient> patients;
    List<TreatmentRecord> treatmentRecords;
    List<TriageRecord> triageRecords;

    public EmergencyRoom() {
        this.patients = new ArrayList<>();
        this.treatmentRecords = new ArrayList<>();
        this.triageRecords = new ArrayList<>();
    }

    public List<Patient> getPatients() {
        return patients;
    }
    public List<TreatmentRecord> getTreatmentRecords() {
        return treatmentRecords;
    }
    public List<TriageRecord> getTriageRecords() {
        return triageRecords;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    public void addTreatmentRecord(TreatmentRecord treatmentRecord) {
        treatmentRecords.add(treatmentRecord);
    }
    public void addTriageRecord(TriageRecord triageRecord) {
        triageRecords.add(triageRecord);
    }
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }
    public void removeTreatmentRecord(TreatmentRecord treatmentRecord) {
        treatmentRecords.remove(treatmentRecord);
    }
    public void removeTriageRecord(TriageRecord triageRecord) {
        triageRecords.remove(triageRecord);
    }

    public boolean searchTreatmentRecordsByPatientId(Long patientId) {
        for (TreatmentRecord tr : treatmentRecords) {
            if (tr.getPatientId().equals(patientId)) {
                System.out.println("Found Treatment Record for Patient ID " + patientId + ": " + tr.getDiagnosis());
                return true;
            }
        }
        return false;
    }
    public boolean searchTriageRecordsByPatientId(Long patientId) {
        for (TriageRecord tr : triageRecords) {
            if (tr.getPatientId().equals(patientId)) {

                System.out.println("Found Triage Record for Patient ID " + patientId + ": ");
                return true;
            }
        }
        return false;
    }

    public TreatmentRecord searchTreatmentRecordsByPatientIdAndReturnRecord(Long patientId){
        for (TreatmentRecord tr : treatmentRecords) {
            if (tr.getPatientId().equals(patientId)) {
                return tr;
            }
        }
        return null;
    }

    public void showTreatmentRecordForSpecificPatient(Long patientId){
        TreatmentRecord tr = searchTreatmentRecordsByPatientIdAndReturnRecord(patientId);
        System.out.println(tr);
    }



}
