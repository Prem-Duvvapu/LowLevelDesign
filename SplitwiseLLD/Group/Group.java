package SplitwiseLLD.Group;

import SplitwiseLLD.Expense.Expense;
import SplitwiseLLD.Expense.ExpenseController;
import SplitwiseLLD.Expense.ExpenseSplitType;

import java.util.*;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;
    ExpenseController expenseController;

    Group() {
        groupMembers=new ArrayList<>();
        expenseList=new ArrayList<>();
        expenseController=new ArrayList<>();
    }

    public Expense createExpense(String expenseId,String description,double expenseAmount,User paidByUser,ExpenseSplitType splitType,List<Split> splitList) {
        Expense expense=new Expense(expenseId, description, expenseAmount, user, splitType, splitList);
        expenseList.add(expense);
        return expense;
    }
}
