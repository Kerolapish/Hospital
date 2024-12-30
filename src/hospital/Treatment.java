package hospital;

public class Treatment {
	
    private String description;
    private int duration;

    public Treatment(String description, int duration) {
        this.description = description;
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }
}
