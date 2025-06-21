package StackOverflowLLD;
import java.util.*;

public class Comment {
    private final int id;
    private String content;
    private User author;
    private Date creationDate;

    public Comment(User author, String content) {
        this.id=generateId();
        this.author=author;
        this.content=content;
        this.creationDate=new Date();
    }

    private int generateId() {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


}
