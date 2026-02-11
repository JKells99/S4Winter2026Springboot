package com.keyin.javareview.emergsystemsimple;

import java.time.LocalDateTime;

public class TreatmentRecord {

    private String diagnosis;
    private String treatmentPlan;
    private String medicationsToTake;
    private String doctorName;
    private LocalDateTime treatmentTime;

    private Long patientId;
    private boolean discharged = false;

    public TreatmentRecord(String diagnosis, String treatmentPlan, String medicationsToTake, String doctorName, LocalDateTime treatmentTime, Long patientId) {
        this.diagnosis = diagnosis;
        this.treatmentPlan = treatmentPlan;
        this.medicationsToTake = medicationsToTake;
        this.doctorName = doctorName;
        this.treatmentTime = treatmentTime;
        this.patientId = patientId;

    }

    public TreatmentRecord() {

    }


    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }



    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public String getMedicationsToTake() {
        return medicationsToTake;
    }

    public void setMedicationsToTake(String medicationsToTake) {
        this.medicationsToTake = medicationsToTake;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDateTime getTreatmentTime() {
        return treatmentTime;
    }

    public void setTreatmentTime(LocalDateTime treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    @Override
    public String toString() {
        return "TreatmentRecord{" +
                "diagnosis='" + diagnosis + '\'' +
                ", treatmentPlan='" + treatmentPlan + '\'' +
                ", medicationsToTake='" + medicationsToTake + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", treatmentTime=" + treatmentTime +
                '}';
    }


}
