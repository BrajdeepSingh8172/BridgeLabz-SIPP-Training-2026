import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String title;

    public JobRole(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getCoreRequiredSkill();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public String getCoreRequiredSkill() {
        return "Data Structures, Algorithms, Object-Oriented Programming";
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public String getCoreRequiredSkill() {
        return "Machine Learning, Python, Statistical Inference";
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T role;

    public Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getRole() {
        return role;
    }
}

public class ResumeScreeningSystem {
    public static void runPipelineFilter(List<Resume<? extends JobRole>> pipeline) {
        System.out.println("--- Processing Candidates Through Screening Pipeline ---");
        for (Resume<? extends JobRole> resume : pipeline) {
            System.out.println("Candidate: " + resume.getCandidateName());
            System.out.println("Target Position: " + resume.getRole().getTitle());
            System.out.println("Required Verification: " + resume.getRole().getCoreRequiredSkill());
            System.out.println("Status: QUEUED FOR INTERVIEW");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> devCandidate = new Resume<>("Charlie Brown", new SoftwareEngineer());
        Resume<DataScientist> aiCandidate = new Resume<>("Dana Scully", new DataScientist());

        List<Resume<? extends JobRole>> generalPipeline = new ArrayList<>();
        generalPipeline.add(devCandidate);
        generalPipeline.add(aiCandidate);

        runPipelineFilter(generalPipeline);
    }
}