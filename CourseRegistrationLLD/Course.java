package CourseRegistrationLLD;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private final String code;
    private final String name;
    private String instructor;
    private int maxCapacity;
    private Set<Student> enrolledStudents;

    public Course(String code, String name, String instructor, int maxCapacity) {
        this.code=code;
        this.name=name;
        this.instructor=instructor;
        this.maxCapacity=maxCapacity;
        this.enrolledStudents=new HashSet<>();
    }

    public synchronized void enroll(Student student) {
        if (enrolledStudents.size()>=maxCapacity)
            throw new IllegalStateException("Course is full");

        enrolledStudents.add(student);
    }

    public synchronized void drop(Student student) {
        enrolledStudents.remove(student);
    }

    public synchronized boolean isCourseAvailable() {
        return enrolledStudents.size()<maxCapacity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}
