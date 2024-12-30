package hospital;

public class Equipment {

    private String type;
    private String status;

    // Constructor allowing type and status input
    public Equipment(String type, String status) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Equipment type cannot be null or empty.");
        }
        this.type = type;
        this.status = status != null ? status : "Available"; // Default status is "Available"
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void allocate() {
        this.status = "Allocated";
    }

    public void release() {
        this.status = "Available";
    }

    @Override
    public String toString() {
        return "Equipment Type: " + type + ", Status: " + status;
    }
}
