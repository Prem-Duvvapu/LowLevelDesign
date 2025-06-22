package TaskManagementSystemLLD;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
    private final String id;
    private String title;
    private String description;
    private Date dueDate;
    private TaskStatus status;
    private TaskPriority priority;
    private User assignee;
    private List<Comment> comments;
    private List<Task> subTasks;

    public Task(String id, String title, String description, Date dueDate,TaskPriority priority, User assignee) {
        this.id=id;
        this.title=title;
        this.description=description;
        this.dueDate=dueDate;
        this.priority=priority;
        this.status=TaskStatus.TODO;
        this.assignee=assignee;
        this.comments=new ArrayList<>();
        this.subTasks=new ArrayList<>();
    }

    public synchronized void addComment(Comment comment) {
        comments.add(comment);
    }

    public synchronized void addSubTask(Task subTask) {
        subTasks.add(subTask);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public synchronized void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public synchronized void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public synchronized void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public synchronized void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public synchronized void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public User getAssignee() {
        return assignee;
    }

    public synchronized void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public synchronized void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public synchronized void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }
}
