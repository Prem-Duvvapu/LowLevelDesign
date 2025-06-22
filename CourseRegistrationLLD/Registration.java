package CourseRegistrationLLD;

import java.sql.Timestamp;

public class Registration {
    private final Student student;
    private final Course course;
    private final Timestamp registrationTime;

    public Registration(Student student, Course course) {
        this.student=student;
        this.course=course;
        this.registrationTime=new Timestamp(System.currentTimeMillis());
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public Timestamp getRegistrationTime() {
        return registrationTime;
    }
}
