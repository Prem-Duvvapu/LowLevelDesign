package ATMLLD;

public class CashWithdrawlState extends ATMState {
    public CashWithdrawlState() {
        System.out.println("Please enter the withdrawl amount: ");
    }
    
    @Override
    public void cashWithdrawl(ATM atm,Card card,int withdrawAmount) {
        if (atm.getATMBalance() < withdrawAmount) {
            System.out.println("Insufficient funds in the ATM");
            exit(atm);
        } else if (card.getBankAccount().getBalance() < withdrawAmount) {
            System.out.println("Insufficient funds in your bank account");
            exit(atm);
        } else {
            card.getBankAccount().withDrawBalance(withdrawAmount);
            atm.deductATMBalance(withdrawAmount);

            //Using Chain of Responsibility
            CashWithdrawProcessor processor=new TwoThousandWithdrawProcessort(new FiveHundredWithdrawProcessor(new OneHundredProcessort()));

            processort.withdraw(atm,withdrawAmount);
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
}
