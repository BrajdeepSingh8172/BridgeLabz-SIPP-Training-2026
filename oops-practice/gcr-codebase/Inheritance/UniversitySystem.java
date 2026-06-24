class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class Student extends Person {
    protected final String studentId;
    protected double gpa;

    public Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student{studentId='" + studentId + "', gpa=" + gpa + "}";
    }
}

class GradStudent extends Student {
    private String thesis;

    public GradStudent(String name, int age, String studentId, double gpa, String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString() + ", GradStudent{thesis='" + thesis + "'}";
    }

    public static void main(String[] args) {
        GradStudent gs = new GradStudent("Nitin", 21, "S101", 8.5, "AI Research");
        System.out.println(gs);

        Person p = gs;
        Student s = gs;

        System.out.println("GradStudent IS-A Student: " + (s instanceof Student));
        System.out.println("GradStudent IS-A Person: " + (p instanceof Person));
    }
}
