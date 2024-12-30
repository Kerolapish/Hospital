package hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunHospital {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

        try {
            //Add staff information
        	System.out.println("Staff Details: ");
            System.out.println("Enter Doctor's Name: ");
            String doctorName = scanner.nextLine();
            Doctor doctor = new Doctor(doctorName);

            System.out.println("Enter Nurse's Name: ");
            String nurseName = scanner.nextLine();
            Nurse nurse = new Nurse(nurseName);

            //Create emergency room
            System.out.println("\nRoom Information: ");
            System.out.println("Enter Emergency Room Number: ");
            String roomNumber = scanner.nextLine();
            EmergencyRoom room = new EmergencyRoom(roomNumber);

            //Add patient information
            System.out.println("\nPatient Details: ");
            System.out.println("Enter Patient's Name: ");
            String patientName = scanner.nextLine();
            System.out.println("Enter Patient's Age: ");
            int patientAge = Integer.parseInt(scanner.nextLine());
            Patient patient = new Patient(patientName, patientAge);

            //Assign patient to room
            room.assignPatient(patient);

            //Create medical record
            System.out.println("\nMedical Record: ");
            System.out.println("Enter Diagnosis for the Patient: ");
            String diagnosis = scanner.nextLine();
            doctor.createMedicalRecord(patient, diagnosis);

            //Add treatments
            MedicalRecord record = new MedicalRecord(diagnosis);
            while (true) {
            	System.out.println("\nTreatment Details: ");
                System.out.println("Enter Treatment Description (or type 'done' to finish): ");
                String treatmentDescription = scanner.nextLine();
                if (treatmentDescription.equalsIgnoreCase("done")) {
                    break;
                }
                
                System.out.println("Enter Treatment Duration (minutes): ");
                int treatmentDuration = Integer.parseInt(scanner.nextLine());
                Treatment treatment = new Treatment(treatmentDescription, treatmentDuration);
                
                record.addTreatment(new Treatment(treatmentDescription, treatmentDuration));
            }
            
            patient.setMedicalHistory(record.toString());
            
            //Equipment
            // Equipment management (added after patient treatment)
            List<Equipment> equipmentList = new ArrayList<>();

            // Allow user to input equipment details
            System.out.println("\nEnter the number of equipment to add: ");
            int numOfEquipments = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numOfEquipments; i++) {
                System.out.println("Enter Equipment " + (i + 1) + " Type: ");
                String equipmentType = scanner.nextLine();
                System.out.println("Enter Equipment " + (i + 1) + " Status (Available/Allocated): ");
                String equipmentStatus = scanner.nextLine();

                Equipment equipment = new Equipment(equipmentType, equipmentStatus);
                equipmentList.add(equipment);
            }

            // Display available equipment
            System.out.println("\nAvailable Equipment:");
            for (int i = 0; i < equipmentList.size(); i++) {
                System.out.println((i + 1) + ". " + equipmentList.get(i));
            }

            // Allocate equipment
            System.out.println("Allocate equipment to the patient? (yes/no): ");
            String allocateResponse = scanner.nextLine();
            if (allocateResponse.equalsIgnoreCase("yes")) {
                System.out.println("Enter the equipment number to allocate: ");
                int equipmentNumber = Integer.parseInt(scanner.nextLine()) - 1;

                if (equipmentNumber >= 0 && equipmentNumber < equipmentList.size()) {
                    Equipment selectedEquipment = equipmentList.get(equipmentNumber);
                    selectedEquipment.allocate();
                    System.out.println("Allocated Equipment: " + selectedEquipment);
                } else {
                    System.out.println("Invalid equipment selection.");
                }
            }


            //Nurse evaluates the patient
            nurse.performDuty(patient);

            //Display patient details
            System.out.println("\nPatient Details:");
            patient.displayInfo();

            //Release the room
            room.releaseRoom();

            //Optionally assign another patient
            System.out.println("Do you want to assign another patient? (yes/no): ");
            
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Enter Second Patient's Name: ");
                String secondPatientName = scanner.nextLine();
                System.out.println("Enter Second Patient's Age: ");
                int secondPatientAge = Integer.parseInt(scanner.nextLine());
                Patient secondPatient = new Patient(secondPatientName, secondPatientAge);
                room.assignPatient(secondPatient);

                //Display room status
                System.out.println("\n" + room);
            } else {
                System.out.println("Exiting the system. Goodbye!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
