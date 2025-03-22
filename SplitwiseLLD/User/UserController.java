package SplitwiseLLD.User;

import java.util.*;

public class UserController {
    public List<User> userList;

    public UserController() {
        userList=new ArrayList<>();
    }

    public User getUser(String userId) {
        for (User user: userList)
            if (user.userId.equals(userId))
                return user;

        return null;
    }
}
