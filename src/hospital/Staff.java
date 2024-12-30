package hospital;

public abstract class Staff {
	
    private String name;
    private String role;

    public Staff(String name, String role) {
    	
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public abstract void performDuty(Patient patient);

    @Override
    public String toString() {
        return "Staff Name: " + name + ", Role: " + role;
    }
}
