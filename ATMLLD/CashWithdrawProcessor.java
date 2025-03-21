package ATMLLD;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextWithdrawProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        this.nextWithdrawProcessor=nextCashWithdrawProcessor;
    }

    public void withdraw(ATM atm,int amount) {
        if (nextWithdrawProcessor!=null) {
            nextWithdrawProcessor.withdraw(atm,amount);
        }
    }
}
