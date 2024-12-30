package hospital;

public class Doctor extends Staff {
	
    public Doctor(String name) {
        super(name, "Doctor");
    }

    @Override
    public void performDuty(Patient patient) {
        System.out.println("Doctor " + getName() + " is treating patient " + patient.getName());
    }

    public void createMedicalRecord(Patient patient, String diagnosis) {
    	
        MedicalRecord record = new MedicalRecord(diagnosis);
        patient.setMedicalHistory(record.toString());
        System.out.println("\nDoctor " + getName() + " added a medical record for patient " + patient.getName());
    }
}
