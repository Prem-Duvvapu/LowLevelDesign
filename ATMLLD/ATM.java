package ATMLLD;

public class ATM {
    ATM atmOject=new ATM();

    ATMState state;
    int ATMBalance;
    int twoThousandNotesCount;
    int fiveHundredNotesCount;
    int oneHundredNotesCount;

    ATMState getATMState() {
        return state;
    }

    void setATMState(ATMState state) {
        this.state=state;
    }

    ATM getATMObject() {
        atmOject.setATMState(new IdleState());
        return atmOject;
    }

    int getATMBalance() {
        return ATMBalance;
    }

    void setATMBalance(int ATMBalance,int twoThousandNotesCount,int fiveHundredNotesCount,int oneHundredNotesCount) {
        this.ATMBalance=ATMBalance;
        this.twoThousandNotesCount=twoThousandNotesCount;
        this.fiveHundredNotesCount=fiveHundredNotesCount;
        this.oneHundredNotesCount=oneHundredNotesCount;
    }

    void deductATMBalance(int amount) {
        ATMBalance=ATMBalance-amount;
    }

    int getTwoThousandNotesCount() {
        return twoThousandNotesCount;
    }

    int getFiveHundredNotesCount() {
        return fiveHundredNotesCount;
    }

    int getOneHundredNotesCount() {
        return oneHundredNotesCount;
    }

    void deductTwoThousandNotesCount(int cnt) {
        twoThousandNotesCount=twoThousandNotesCount-cnt;
    }

    void deductFiveHundredNotesCount(int cnt) {
        fiveHundredNotesCount=fiveHundredNotesCount-cnt;
    }

    void deductOneHundredNotesCount(int cnt) {
        oneHundredNotesCount=oneHundredNotesCount-cnt;
    }

    void printATMBalance() {
        System.out.println("Balance: "+getATMBalance());
        System.out.println("Two Thousand Rupee Notes: "+getTwoThousandNotesCount());
        System.out.println("Five Hundred Rupee Notes: "+getFiveHundredNotesCount());
        System.out.println("One Hundred Rupee Notes: "+getOneHundredNotesCount());
    }
}
