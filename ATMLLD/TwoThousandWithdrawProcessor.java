package ATMLLD;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {
    public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCardWithdrawProcessor) {
        super(nextCardWithdrawProcessor);
    }
    
    public void withdraw(ATM atm,int amount) {
        int required=amount/2000;
        int balance=amount%2000;

        if (required<=atm.getTwoThousandNotesCount()) {
            atm.deductTwoThousandNotesCount(required);
        } else {
            atm.deductTwoThousandNotesCount(atm.getTwoThousandNotesCount());
            balance=balance+(required-atm.getTwoThousandNotesCount())*2000;
        }

        if (balance!=0) {
            super.withdraw(atm,balance);
        }
    }
}
