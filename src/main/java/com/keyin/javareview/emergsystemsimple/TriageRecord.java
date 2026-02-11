package com.keyin.javareview.emergsystemsimple;

import java.time.LocalDateTime;

public class TriageRecord {

    private int severity; // 1-5
    private String presentingSymptoms;
    private String notes;
    private LocalDateTime triageTime;
    private String nurseName;
    private Long patientId;

    public TriageRecord(int severity, String presentingSymptoms, String notes, LocalDateTime triageTime, String nurseName, Long patientId) {
        this.severity = severity;
        this.presentingSymptoms = presentingSymptoms;
        this.notes = notes;
        this.triageTime = triageTime;
        this.nurseName = nurseName;
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getPresentingSymptoms() {
        return presentingSymptoms;
    }

    public void setPresentingSymptoms(String presentingSymptoms) {
        this.presentingSymptoms = presentingSymptoms;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getTriageTime() {
        return triageTime;
    }

    public void setTriageTime(LocalDateTime triageTime) {
        this.triageTime = triageTime;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    @Override
    public String toString() {
        return "TriageRecord{" +
                "severity=" + severity +
                ", presentingSymptoms='" + presentingSymptoms + '\'' +
                ", notes='" + notes + '\'' +
                ", triageTime=" + triageTime +
                ", nurseName='" + nurseName + '\'' +
                '}';
    }
}
