package com.keyin.javareview.emergsystemsimple;

import java.time.LocalDateTime;

public class ERTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        EmergencyRoom emergencyRoom = new EmergencyRoom();
        Patient patient1 = new Patient(1L,"John", "Doe", "1990-01-01");
        Patient patient2 = new Patient(2L,"Jane", "Smith", "1985-05-15");
        emergencyRoom.addPatient(patient1);
        emergencyRoom.addPatient(patient2);

        TreatmentRecord tr1 = new TreatmentRecord("Flu", "Rest and hydration", "Tylenol", "Dr. Brown", now.minusHours(1), 1L);
        TreatmentRecord tr2 = new TreatmentRecord("Flu", "Rest and hydration", "Tylenol", "Dr. Brown", now.minusHours(2), 2L);
        emergencyRoom.addTreatmentRecord(tr1);
        emergencyRoom.addTreatmentRecord(tr2);
        emergencyRoom.showTreatmentRecordForSpecificPatient(1L);



    }
}
