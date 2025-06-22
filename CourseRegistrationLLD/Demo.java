package CourseRegistrationLLD;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        CourseRegistrationSystem system=CourseRegistrationSystem.getInstance();

        //Add courses
        Course course1=system.addCourse("CS101", "Operating Systems", "Luffy", 60);
        Course course2=system.addCourse("CS102","Computer Networks","Zoro",50);

        //Add students
        Student student1=system.registerStudent("Nami","nami@op.com");
        Student student2=system.registerStudent("Robin","robin@op.com");

        //Search for courses
        List<Course> searchResults=system.searchCourses("CS");
        System.out.println("Search Results: ");
        for (Course course: searchResults)
            System.out.println(course.getCode()+", "+course.getName());

        //Register courses for students
        system.enroll(student1.getId(), course1.getCode());
        system.enroll(student2.getId(), course1.getCode());
        system.enroll(student2.getId(), course2.getCode());

        //Drop courses for students
//        system.drop(student2.getId(), course1.getCode());

        System.out.println("\n\nRegistrations: ");
        for (Registration registration: system.getRegistrations())
            System.out.println(registration.getStudent().getName()+" registered in "+registration.getCourse().getCode()+" at "+registration.getRegistrationTime());
    }
}
