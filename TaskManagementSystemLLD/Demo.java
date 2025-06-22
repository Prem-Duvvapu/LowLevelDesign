package TaskManagementSystemLLD;

import java.util.Date;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        TaskManager taskManager=TaskManager.getInstance();

        //Create users
        User user1=new User("1","Luffy","luffy@op.com");
        User user2=new User("2","Zoro","zoro@op.com");

        //Create tasks;
        Task task1=new Task("1","Task 1","Description 1",new Date(), TaskPriority.LOW, user1);
        Task task2=new Task("2","Task 2","Description 2",new Date(), TaskPriority.MEDIUM, user2);
        Task task3=new Task("3","Task 3","Description 3",new Date(), TaskPriority.HIGH, user1);

        //Add tasks to task manager
        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);

        //Update a task
        task2.setDescription("updated task 2 description");

        //Search tasks
        List<Task> searchResults=taskManager.searchTasks("Task");
        System.out.println("Tasks with keyword Task: ");
        for (Task task: searchResults)
            System.out.println(task.getTitle());

        //Mark a task as done
        task3.setStatus(TaskStatus.DONE);

        //filter tasks by status
        List<Task> filteredTasks=taskManager.listTasksByStatus(TaskStatus.TODO);
        System.out.println("\nTODO tasks: ");
        for (Task task: filteredTasks)
            System.out.println(task.getTitle());

        //Get tasks assigned to a user
        List<Task> assignedTasks=taskManager.listTasksByUser(user1);
        System.out.println("\nTasks assigned to "+user1.getName()+":");
        for (Task task: assignedTasks)
            System.out.println(task.getTitle());

        //Delete a task
        taskManager.deleteTask(task3.getId());
    }
}
