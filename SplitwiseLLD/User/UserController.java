package SplitwiseLLD.User;

import java.util.*;

public class UserController {
    List<User> userList;

    UserController() {
        userList=new ArrayList<>();
    }

    public User getUser(String userId) {
        for (User user: userList)
            if (user.userId.equals(userId))
                return user;

        return null;
    }
}
