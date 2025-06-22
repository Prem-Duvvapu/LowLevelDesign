package TaskManagementSystemLLD;

import java.util.Date;
import java.util.UUID;

public class Comment {
    private final String id;
    private String content;
    private User author;
    private Date timeStamp;

    public Comment(String content, User author) {
        this.id= UUID.randomUUID().toString();
        this.content=content;
        this.author=author;
        this.timeStamp=new Date();
    }
}
