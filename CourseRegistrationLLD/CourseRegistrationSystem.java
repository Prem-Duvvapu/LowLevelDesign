package CourseRegistrationLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CourseRegistrationSystem {
    private static CourseRegistrationSystem instance;
    private final Map<String, Student> students;
    private final Map<String, Course> courses;
    private final List<Registration> registrations;

    private CourseRegistrationSystem() {
        students=new ConcurrentHashMap<>();
        courses=new ConcurrentHashMap<>();
        registrations=new CopyOnWriteArrayList<>();
    }

    public static CourseRegistrationSystem getInstance() {
        if (instance==null)
            instance=new CourseRegistrationSystem();

        return instance;
    }

    public Student registerStudent(String name, String email) {
        Student student=new Student(name, email);
        students.put(student.getId(),student);
        return student;
    }

    public Course addCourse(String code, String name, String instructor, int maxCapacity) {
        Course course=new Course(code, name, instructor, maxCapacity);
        courses.put(course.getCode(),course);
        return course;
    }

    public synchronized void enroll(String studentId, String courseCode) {
        Student student=students.get(studentId);
        Course course=courses.get(courseCode);

        if (student==null)
            throw new IllegalArgumentException("Student not found");

        if (course==null)
            throw new IllegalArgumentException("Course not found");

        try {
            course.enroll(student);
            student.enroll(course);
            Registration registration=new Registration(student,course);
            registrations.add(registration);
        } catch (IllegalArgumentException e) {
            System.out.println("Enrollment failed: "+e.getMessage());
        }
    }

    public synchronized void drop(String studentId, String courseCode) {
        Student student=students.get(studentId);
        Course course=courses.get(courseCode);

        if (student==null)
            throw new IllegalArgumentException("Student not found");

        if (course==null)
            throw new IllegalArgumentException("Course not found");

        course.drop(student);
        student.drop(course);

        for (Registration registration: registrations) {
            if (registration.getCourse() == course && registration.getStudent() == student) {
                registrations.remove(registration);
                break;
            }
        }
    }

    public List<Course> getAvailableCourses() {
        return courses.values().stream()
                .filter(Course::isCourseAvailable)
                .toList();
    }

    public List<Course> searchCourses(String query) {
        return courses.values().stream()
                .filter(course -> (course.getCode().contains(query) || course.getName().contains(query)))
                .toList();
    }

    public static void setInstance(CourseRegistrationSystem instance) {
        CourseRegistrationSystem.instance = instance;
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public Map<String, Course> getCourses() {
        return courses;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }
}
