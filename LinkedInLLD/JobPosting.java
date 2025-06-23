package LinkedInLLD;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class JobPosting {
    private final String id;
    private String title;
    private String company;
    private String description;
    private String location;
    private Date postDate;
    private Map<String, User> applicants;

    public JobPosting(String title, String company, String description, String location) {
        this.id= UUID.randomUUID().toString();
        this.title=title;
        this.company=company;
        this.description=description;
        this.location=location;
        this.postDate=new Date();
        this.applicants=new ConcurrentHashMap<>();
    }

    public void apply(User user) {
        if (applicants.containsKey(user.getId()))
            throw new IllegalArgumentException("User has already applied to this job");

        applicants.put(user.getId(), user);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Map<String, User> getApplicants() {
        return applicants;
    }

    public void setApplicants(Map<String, User> applicants) {
        this.applicants = applicants;
    }
}
