package com.keyin.javareview.emergsystemsimple;

import java.time.LocalDateTime;

public class Patient {
    private Long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private LocalDateTime arrivalTime;
    private Status status = Status.WAITING;

    public Patient(Long id, String firstName, String lastName, String dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.arrivalTime = LocalDateTime.now();
    }

    public Patient(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.arrivalTime = LocalDateTime.now();
    }

    public Patient() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void patientStatusCheckAndUpdateIfNeeded(Long patientId, EmergencyRoom emergencyRoom){
        if(emergencyRoom.searchTriageRecordsByPatientId(patientId)){
            setStatus(Status.TRIAGED);
        }
        if(emergencyRoom.searchTreatmentRecordsByPatientId(patientId)){
            setStatus(Status.IN_TREATMENT);
        }

        TreatmentRecord treatmentRecord = emergencyRoom.searchTreatmentRecordsByPatientIdAndReturnRecord(patientId);
        if(treatmentRecord == null){
            return;
        }

        if(treatmentRecord.isDischarged()){
            setStatus(Status.DISCHARGED);
        }


    }
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
