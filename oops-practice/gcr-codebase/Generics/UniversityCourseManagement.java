import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String code;
    private String title;

    public CourseType(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getEvaluationMethod();

    @Override
    public String toString() {
        return code + ": " + title + " (" + getEvaluationMethod() + ")";
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String code, String title) {
        super(code, title);
    }

    @Override
    public String getEvaluationMethod() {
        return "Written Examination (100%)";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String code, String title) {
        super(code, title);
    }

    @Override
    public String getEvaluationMethod() {
        return "Thesis Presentation and Dissertation";
    }
}

class Course<T extends CourseType> {
    private T details;

    public Course(T details) {
        this.details = details;
    }

    public T getDetails() {
        return details;
    }
}

public class UniversityCourseManagement {
    public static void printCourseRoster(List<Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course.getDetails());
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>(new ExamCourse("MATH101", "Calculus I"));
        Course<ResearchCourse> physics = new Course<>(new ResearchCourse("PHYS501", "Quantum Mechanics Lab"));

        List<Course<? extends CourseType>> roster = new ArrayList<>();
        roster.add(math);
        roster.add(physics);

        System.out.println("--- Current University Courses ---");
        printCourseRoster(roster);
    }
}