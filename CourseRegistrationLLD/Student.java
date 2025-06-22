package CourseRegistrationLLD;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student {
    private final String id;
    private String name;
    private String email;
    private List<Course> enrolledCourses;

    public Student(String name, String email) {
        this.id= UUID.randomUUID().toString();
        this.name=name;
        this.email=email;
        this.enrolledCourses=new ArrayList<>();
    }

    public void enroll(Course course) {
        enrolledCourses.add(course);
    }

    public void drop(Course course) {
        enrolledCourses.remove(course);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}