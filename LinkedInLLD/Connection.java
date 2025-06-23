package LinkedInLLD;

import java.sql.Timestamp;

public class Connection {
    private User user;
    private Timestamp connectionDate;

    public Connection(User user, Timestamp connectionDate) {
        this.user=user;
        this.connectionDate=connectionDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(Timestamp connectionDate) {
        this.connectionDate = connectionDate;
    }
}
