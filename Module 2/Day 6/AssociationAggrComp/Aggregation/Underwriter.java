package Aggregation;

import java.util.ArrayList;
import java.util.List;

public class Underwriter {

    private String name;
    private List<LoanApplication> applications;

    public Underwriter(String name) {
        this.name = name;
        this.applications = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addApplication(LoanApplication app) {
        applications.add(app);
    }

    public void removeApplication(LoanApplication app) {
        applications.remove(app);
    }

    public List<LoanApplication> getApplications() {
        return applications;
    }

    @Override
    public String toString() {
        return "Underwriter: " + name;
    }
}