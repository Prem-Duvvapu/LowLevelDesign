package SplitwiseLLD.Expense.Split;

import SplitwiseLLD.User.*;

public class Split {
    public User user;
    public double amountOwe;

    public Split(User user,double amountOwe) {
        this.user=user;
        this.amountOwe=amountOwe;
    }
}