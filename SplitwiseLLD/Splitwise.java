package SplitwiseLLD;

import SplitwiseLLD.Expense.ExpenseSplitType;
import SplitwiseLLD.Group.Group;
import SplitwiseLLD.Group.GroupController;
import SplitwiseLLD.User.UserController;

public class Splitwise {
    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    SplitWise() {
        userController=new UserController();
        groupController=new GroupController();
        balanceSheetController=new BalanceSheetController();
    }
    
    public void demo() {
        setupUserAndGroup();

        //1. add members to the group
        Group group=groupController.getGroup("G1001");
        group.userList.add(userController.getUser("U1002"));
        group.userList.add(userController.getUser("U1003"));

        //2. Create an expense inside the group
        List<Split> splits=new ArrayList<>();
        Split split1=new Split(UserController.getUser("U1001",300));
        Split split2=new Split(UserController.getUser("U1002",300));
        Split split3=new Split(UserController.getUser("U1003",300));
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);
        group.createExpense("Exp001", "Lunch", 900, splits,ExpenseSplitType.EQUAL,userController.getUser("U1001"));

        List<Split> splits2=new ArrayList<>();
        Splits split2_1=new Split(UserController.getUser("U1001"),400);
        Splits split2_2=new Split(UserController.getUser("U1002"),100);
        splits2.add(split2_1);
        splits2.add(split3_2);
        group.createExpense("Exp002","Dinner",500,splits2,ExpenseSplitType.UNEQUAL,userController.getUser("U2001"));

        for (User user: userController.userList) {
            balanceSheetController.showBalanceSheetOfUser(user);
        }
    }

    public void setupUserAndGroup() {
        addUsersToSplitWiseApp();

        User user1=userController.getUser("U1001");
        groupController.createNewGroup("G1001", "Outing With Friends", user1);
    }

    public void addUsersToSplitWiseApp() {
        User user1=new User("U1001","User1");
        User user2=new User("U1002","User2");
        User user3=new User("U1003","User3");

        userController.add(user1);
        userController.add(user2);
        userController.add(user3);
    }
}
