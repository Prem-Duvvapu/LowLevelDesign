package ATMLLD;

public class SelectOperationState extends ATMState {
    public SelectOperationState() {
        showOperations();
    }

    @Override
    public void selectOperation(ATM atm,Card card,TransactionType transactionType) {
        switch(transactionType) {
            case CASH_WITHDRAWL:
                atm.setATMState(new CashWithdrawlState());
                break;
            case CHECK_BALANCE:
                atm.setATMState(new CheckBalanceState());
                break;
            default:
                System.out.println("Invalid option");
                exit(atm);
        }
    }

    @Override
    public void exit(ATM atmObject){
        returnCard();
        atmObject.setATMState(new IdleState());
        System.out.println("Exited...");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }

    public void showOperations() {
        System.out.println("Please select the Operations");
        TransactionType.printTransactionTypes();
    }
}
