package SplitwiseLLD.User;

import SplitwiseLLD.UserExpenseBalanceSheet;

public class User {
    String userId;
    String userName;
    UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String userId,String userName) {
        this.userId=userId;
        this.userName=userName;
    }
}
