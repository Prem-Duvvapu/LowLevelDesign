package LinkedInLLD;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        LinkedInService linkedInService=LinkedInService.getInstance();

        //User Registration
        User user1=linkedInService.regiserUser("Luffy","luffy@op.com","meat");
        User user2=linkedInService.regiserUser("Zoro","zoro@op.com","booze");

        // Set user profile
        Profile profile=new Profile();
        profile.setHeadline("Software Engineer");
        profile.setSummary("Skilled in Backend and DevOps");
        user1.setProfile(profile);

        //Send connection request
        linkedInService.sendConnectionRequest(user1, user2);

        //Accept connection request
        linkedInService.acceptConnectionRequest(user2,user1);

        //Post a job
        linkedInService.postJob("Software Development Engineer","Amazon","knowledge of DSA","Hyderabad");
        linkedInService.postJob("Software Engineer","Google","Good at problem solving","Bangalore");

        //Search for users
        List<User> searchResults=linkedInService.searchUsers("Luffy");
        System.out.println("Search Results:");
        for (User user: searchResults) {
            System.out.println("Name: " + user.getName());
            System.out.println("Headline: " + user.getProfile().getHeadline());
            System.out.println();
        }

        //Search for job postings
        List<JobPosting> jobSearchResults=linkedInService.searchJobs("Engineer");
        System.out.println("\nJob Posting Results: ");
        for (JobPosting jobPost: jobSearchResults) {
            System.out.println("Title: "+jobPost.getTitle());
            System.out.println("Company: "+jobPost.getCompany());
            System.out.println();
        }

        //Send a message
        linkedInService.sendMessage(user1, user2, "Let's go");

        //Get notifications
        List<Notification> notifications=user2.getNotifications();
        System.out.println("\nNotifications for "+user2.getName());
        for (Notification notification: notifications) {
            System.out.println("Type: "+notification.getType());
            System.out.println("Content: "+notification.getContent());
            System.out.println();
        }
    }
}
