import java.util.*;

// === Abstract JobRole Class ===
abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract String requiredSkills();

    @Override
    public String toString() {
        return candidateName + " applying for " + this.getClass().getSimpleName()
                + " - Required Skills: " + requiredSkills();
    }
}

// === Subclasses for Different Roles ===
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public String requiredSkills() {
        return "Java, Data Structures, Algorithms";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public String requiredSkills() {
        return "Python, ML, Statistics, Data Analysis";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public String requiredSkills() {
        return "Business Strategy, Communication, UX";
    }
}

// === Generic Resume Class ===
class Resume<T extends JobRole> {
    private T jobRole;
    private String resumeText;

    public Resume(T jobRole, String resumeText) {
        this.jobRole = jobRole;
        this.resumeText = resumeText;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String getResumeText() {
        return resumeText;
    }

    public void display() {
        System.out.println(jobRole);
        System.out.println("Resume: " + resumeText);
        System.out.println("---------------------------------------------------");
    }
}

// === Resume Processing Utility ===
class ResumeProcessor {

    // Generic method with bounded type
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Screening Resume for: " + resume.getJobRole().getCandidateName());
        resume.display();
    }

    // Wildcard method for pipeline processing
    public static void screenPipeline(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println("Pipeline Screening: " + resume.getJobRole().getClass().getSimpleName());
            resume.display();
        }
    }
}

// === Main Class ===
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        // Create resumes for different roles
        Resume<SoftwareEngineer> seResume = new Resume<>(
            new SoftwareEngineer("Alice"), "Experienced in Java and Spring Boot with 3 years in backend development.");

        Resume<DataScientist> dsResume = new Resume<>(
            new DataScientist("Bob"), "Expert in machine learning, pandas, and model deployment.");

        Resume<ProductManager> pmResume = new Resume<>(
            new ProductManager("Charlie"), "Led 5 successful product launches with strong UX and agile experience.");

        // Process individual resume
        System.out.println("=== Individual Resume Screening ===");
        ResumeProcessor.processResume(seResume);
        ResumeProcessor.processResume(dsResume);
        ResumeProcessor.processResume(pmResume);

        // Pipeline screening using wildcards
        List<Resume<? extends JobRole>> resumeList = new ArrayList<>();
        resumeList.add(seResume);
        resumeList.add(dsResume);
        resumeList.add(pmResume);

        System.out.println("=== Batch Pipeline Screening ===");
        ResumeProcessor.screenPipeline(resumeList);
    }
}
