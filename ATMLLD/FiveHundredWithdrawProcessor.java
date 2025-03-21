package ATMLLD;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }
    
    public void withdraw(ATM atm,int amount) {
        int required=amount/500;
        int balance=amount%500;

        if (required<=atm.getFiveHundredNotesCount()) {
            atm.deductFiveHundredNotesCount(required);
        } else {
            atm.deductTwoThousandNotesCount(atm.getFiveHundredNotesCount());
            balance=balance+(required-atm.getFiveHundredNotesCount())*500;
        }

        if (balance!=0) {
            super.withdraw(atm,balance);
        }
    }
}
