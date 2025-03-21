package ATMLLD;

public abstract class ATMState {
    public void insertCard(ATM atm, Card card) {
        System.out.println("OOPS! Something went wrong");
    }

    public void authenticatePin(ATM atm, Card card,String pin) {
        System.out.println("OOPS! Something went wrong");
    }

    public void selectOperation(ATM atm,Card card,TransactionType transactionType) {
        System.out.println("OOPS! Something went wrong");
    }

    public void cashWithdrawl(ATM atm,Card card,int withdrawAmount) {
        System.out.println("OOPS! Something went wrong");
    }

    public void displayBalance(ATM atm, Card card) {
        System.out.println("OOPS! Something went wrong");
    }

    public void returnCard() {
        System.out.println("OOPS! Something went wrong");
    }

    public void exit(ATM atm) {
        System.out.println("OOPS! Something went wrong");
    }
}
