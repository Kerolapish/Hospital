package hospital;

public class EmergencyRoom {
	
    private String roomNumber;
    private String status;
    private Patient currentPatient;

    public EmergencyRoom(String roomNumber) {
        this.roomNumber = roomNumber;
        this.status = "Available";
        this.currentPatient = null;
    }

    public void assignPatient(Patient patient) {
        if (!status.equals("Available")) {
            throw new IllegalStateException("Room is not available.");
        }
        
        this.currentPatient = patient;
        this.status = "Occupied";
        
        System.out.println("\nPatient " + patient.getName() + " assigned to room " + roomNumber);
    }

    public void releaseRoom() {
        if (status.equals("Available")) {
            throw new IllegalStateException("Room is already available.");
        }
        
        System.out.println("\nRoom " + roomNumber + " released from patient " + currentPatient.getName());
        
        this.currentPatient = null;
        this.status = "Available";
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Status: " + status +
               (currentPatient != null ? ", Assigned to: " + currentPatient.getName() : "");
    }
}
