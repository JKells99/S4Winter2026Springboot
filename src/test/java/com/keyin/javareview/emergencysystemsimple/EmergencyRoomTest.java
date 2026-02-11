package com.keyin.javareview.emergencysystemsimple;

import com.keyin.javareview.emergsystemsimple.EmergencyRoom;
import com.keyin.javareview.emergsystemsimple.Patient;
import com.keyin.javareview.emergsystemsimple.TriageRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class EmergencyRoomTest {

    @Test
    public void testAddPatient(){
        EmergencyRoom emergencyRoom = new EmergencyRoom();
        Patient patient = new Patient("John", "Doe", "1990-01-01");
        emergencyRoom.addPatient(patient);
        Assertions.assertEquals(1, emergencyRoom.getPatients().size());
    }

    @Test
    public void testRemovePatient(){
        EmergencyRoom emergencyRoom = new EmergencyRoom();
        Patient patient = new Patient("John", "Doe", "1990-01-01");
        emergencyRoom.addPatient(patient);
        emergencyRoom.removePatient(patient);
        Assertions.assertEquals(0, emergencyRoom.getPatients().size());
    }
    @Test
    public void testAddTriageRecord(){
        EmergencyRoom emergencyRoom = new EmergencyRoom();
        Patient patient = new Patient(1L,"John", "Doe", "1990-01-01");
        emergencyRoom.addPatient(patient);
        TriageRecord triageRecord = new TriageRecord(3,"Yeeting","Patinet Wont stop yeeting", LocalDateTime.now(),"LAURA",1L);
        emergencyRoom.addTriageRecord(triageRecord);
        Assertions.assertEquals(1, emergencyRoom.getTriageRecords().size());
        Assertions.assertTrue(emergencyRoom.getTriageRecords().contains(triageRecord));
        Assertions.assertNotEquals(2L, (long) emergencyRoom.getTriageRecords().getFirst().getPatientId());

    }
}
