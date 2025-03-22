package SplitwiseLLD.Group;

import SplitwiseLLD.Expense.*;
import SplitwiseLLD.User.*;
import SplitwiseLLD.Expense.Split.*;

import java.util.*;

public class Group {
    public String groupId;
    public String groupName;
    public List<User> groupMembers;
    public List<Expense> expenseList;
    public ExpenseController expenseController;

    Group() {
        groupMembers=new ArrayList<>();
        expenseList=new ArrayList<>();
        expenseController=new ExpenseController();
    }

    public Expense createExpense(String expenseId,String description,double expenseAmount,User paidByUser,ExpenseSplitType splitType,List<Split> splitList) {
        Expense expense=new Expense(expenseId, description, expenseAmount, paidByUser, splitType, splitList);
        expenseList.add(expense);
        return expense;
    }
}
