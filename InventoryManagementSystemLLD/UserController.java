package InventoryManagementSystemLLD;

import java.util.List;

public class UserController {
    public List<User> userList;

    public UserController(List<User> userList) {
        this.userList=userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }

    public User getuser(int userId) {
        for (User user: userList)
            if (user.userId==userId)
                return user;

        return null;
    }
}
