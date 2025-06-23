package LinkedInLLD;

import java.util.Date;
import java.util.UUID;

public class Message {
    private final String id;
    private User sender;
    private User receiver;
    private String content;
    private Date timestamp;

    public Message(User sender, User receiver, String content) {
        this.id= UUID.randomUUID().toString();
        this.sender=sender;
        this.receiver=receiver;
        this.content=content;
        this.timestamp=new Date();
    }
}
