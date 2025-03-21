package ATMLLD;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor {
    public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }
    
    public void withdraw(ATM atm,int amount) {
        int required=amount/100;
        int balance=amount%100;

        if (required<=atm.getOneHundredNotesCount()) {
            atm.deductOneHundredNotesCount(required);
        } else {
            atm.deductTwoThousandNotesCount(atm.getOneHundredNotesCount());
            balance=balance+(required-atm.getOneHundredNotesCount())*100;
        }

        if (balance!=0) {
            System.out.println("Something went wrong");
        }
    }
}
