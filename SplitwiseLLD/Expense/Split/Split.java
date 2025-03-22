package SplitwiseLLD.Expense.Split;

import SplitwiseLLD.User.User;

public class Split {
    User user;
    double amountOwe;

    public Split(User user,double amountOwe) {
        this.user=user;
        this.amountOwe=amountOwe;
    }
}