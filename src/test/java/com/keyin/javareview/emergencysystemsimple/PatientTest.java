package com.keyin.javareview.emergencysystemsimple;

import com.keyin.javareview.emergsystemsimple.EmergencyRoom;
import com.keyin.javareview.emergsystemsimple.Patient;
import com.keyin.javareview.emergsystemsimple.Status;
import com.keyin.javareview.emergsystemsimple.TriageRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class PatientTest {

    @Test
    void testPatient() {
        Patient patient = new Patient("John", "Doe", "1990-01-01");
        Assertions.assertEquals("John", patient.getFirstName());
        Assertions.assertEquals("Doe", patient.getLastName());
        Assertions.assertEquals(Status.WAITING, patient.getStatus());
    }

    @Test
    void patientStatusCheckAndUpdateIfNeededTest() {
        Patient patient = new Patient(1L, "John", "Doe", "1990-01-01");
        EmergencyRoom emergencyRoom = new EmergencyRoom();
        emergencyRoom.addPatient(patient);
        Assertions.assertEquals(Status.WAITING, patient.getStatus());
        // Simulate status update
        TriageRecord triageRecord = new TriageRecord(2,"Cough, Mild Fever","Patient Seems Ok right now, gave fluids and sent to waiting room", LocalDateTime.now(),"LAURA",1L);
        emergencyRoom.addTriageRecord(triageRecord);
        patient.patientStatusCheckAndUpdateIfNeeded(1L, emergencyRoom);
        Assertions.assertEquals(Status.TRIAGED, patient.getStatus());

    }
}
