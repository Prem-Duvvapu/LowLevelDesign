package SplitwiseLLD.User;

import SplitwiseLLD.UserExpenseBalanceSheet;

public class User {
    public String userId;
    public String userName;
    public UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String userId,String userName) {
        this.userId=userId;
        this.userName=userName;
    }
}
