package LinkedInLLD;

import java.util.Date;
import java.util.UUID;

public class Notification {
    private final String id;
    private User user;
    private NotificationType type;
    private String content;
    private Date timestamp;

    public Notification(User user, NotificationType type, String content) {
        this.id= UUID.randomUUID().toString();
        this.user=user;
        this.type=type;
        this.content=content;
        this.timestamp=new Date();
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
