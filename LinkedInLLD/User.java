package LinkedInLLD;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class User {
    private final String id;
    private String name;
    private String email;
    private String password;
    private Profile profile;
    private List<Connection> connections;
    private List<Message> inbox;
    private List<Message> sentMessages;
    private List<Notification> notifications;
    private List<User> connectionRequests;

    public User(String name, String email, String password) {
        this.id= UUID.randomUUID().toString();
        this.name=name;
        this.email=email;
        this.password=password;
        connections=new ArrayList<>();
        inbox=new ArrayList<>();
        sentMessages=new ArrayList<>();
        notifications=new ArrayList<>();
        connectionRequests=new ArrayList<>();
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void addToInbox(Message message) {
        inbox.add(message);
    }

    public void addToSentMessages(Message message) {
        sentMessages.add(message);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public void setInbox(List<Message> inbox) {
        this.inbox = inbox;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<User> getConnectionRequests() {
        return connectionRequests;
    }

    public void setConnectionRequests(List<User> connectionRequests) {
        this.connectionRequests = connectionRequests;
    }
}
