package TaskManagementSystemLLD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TaskManager {
    private static TaskManager instance;
    private Map<String, Task> tasks;

    private TaskManager() {
        tasks=new ConcurrentHashMap<>();
    }

    public static TaskManager getInstance() {
        if (instance==null)
            instance=new TaskManager();

        return instance;
    }

    public void createTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public Task getTaskById(String taskId) {
        if (!tasks.containsKey(taskId))
            throw new IllegalArgumentException("No task found with id: "+taskId);

        return tasks.get(taskId);
    }

    public List<Task> listTasksByUser(User user) {
        return tasks.values().stream()
                .filter(task -> user.equals(task.getAssignee()))
                .collect(Collectors.toList());
    }

    public List<Task> listTasksByStatus(TaskStatus status) {
        return tasks.values().stream()
                .filter(task -> task.getStatus()==status)
                .collect(Collectors.toList());
    }

    public void deleteTask(String taskId) {
        tasks.remove(taskId);
    }

    public List<Task> searchTasks(String keyword) {
        List<Task> matchingTasks=new ArrayList<>();

        for (Task task: tasks.values())
            if (task.getTitle().contains(keyword) || task.getDescription().contains(keyword))
                matchingTasks.add(task);

        return matchingTasks;
    }
}
