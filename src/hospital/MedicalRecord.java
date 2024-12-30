package hospital;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
	
    private String diagnosis;
    private List<Treatment> treatments;

    public MedicalRecord(String diagnosis) {
        this.diagnosis = diagnosis;
        this.treatments = new ArrayList<>();
    }

    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

    @Override
    public String toString() {
    	StringBuilder record = new StringBuilder("Diagnosis: " + diagnosis + "\n");
        for (Treatment treatment : treatments) {
            record.append("Treatment: ").append(treatment.getDescription())
                  .append("\nDuration: ").append(treatment.getDuration()).append(" minutes");
        }
        
        return record.toString();
    }
}
