package hospital;

public abstract class Emergency {
	
    private String name;

    public Emergency(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayInfo();
}
