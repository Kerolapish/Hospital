package hospital;

public class Patient extends Emergency {
	
    private int age;
    private String medicalHistory;
    private String assignedPersonnel;

    public Patient(String name, int age) {
        super(name);
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than zero.");
        }
        
        this.age = age;
        this.medicalHistory = "No records available.";
        this.assignedPersonnel = "Not assigned.";
    }

    public int getAge() {
        return age;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAssignedPersonnel() {
        return assignedPersonnel;
    }

    public void setAssignedPersonnel(String assignedPersonnel) {
        this.assignedPersonnel = assignedPersonnel;
    }

    @Override
    public void displayInfo() {
        System.out.println("Patient Name: " + getName() + "\nAge: " + age + "\nAssigned Personnel: " + assignedPersonnel);
        System.out.println("\nMedical History:");
        System.out.println(medicalHistory);
    }
}
