package hospital;

public class Nurse extends Staff {
    public Nurse(String name) {
        super(name, "Nurse");
    }

    @Override
    public void performDuty(Patient patient) {
        System.out.println("\nNurse " + getName() + " is evaluating patient " + patient.getName());
    }
}
