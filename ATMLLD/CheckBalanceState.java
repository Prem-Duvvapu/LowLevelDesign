package ATMLLD;

public class CheckBalanceState extends ATMState {
    @Override
    public void displayBalance(ATM atm,Card card) {
        System.out.println("Your balance is: "+card.getBankAccount().getBalance());
        exit(atm);
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
}
