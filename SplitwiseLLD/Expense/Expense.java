package SplitwiseLLD.Expense;

import SplitwiseLLD.Expense.*;
import SplitwiseLLD.Expense.Split.*;
import SplitwiseLLD.User.*;
import java.util.*;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType splitType;
    List<Split> splitDetails=new ArrayList<>();

    public Expense(String expenseId,String description,double expenseAmount,User paidByUser,ExpenseSplitType splitType,List<Split> splitDetails) {
        this.expenseId=expenseId;
        this.description=description;
        this.expenseAmount=expenseAmount;
        this.paidByUser=paidByUser;
        this.splitType=splitType;
        this.splitDetails=splitDetails;
    }
}