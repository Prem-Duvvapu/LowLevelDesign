package ATMLLD;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {
       ATMRoom room=new ATMRoom();
       room.initialize();

       room.atm.printATMBalance();

       room.atm.getATMState().insertCard(room.atm,room.user.card);
       room.atm.getATMState().authenticatePin(room.atm, room.user.card, "1234");
       room.atm.getATMState().selectOperation(room.atm, room.user.card, TransactionType.CASH_WITHDRAWL);
       room.atm.getATMState().cashWithdrawl(room.atm, room.user.card, 3300);
        
       room.atm.printATMBalance();
    }

    void initialize() {
        atm=new ATM();
        atm.setATMBalance(5000,1,  4, 10);

        this.user=createUser();
    }

    User createUser() {
        User user=new User().
        user.setCard(createCard());

        return user;
    }

    Card createCard() {
        Card card=new Card();
        card.setBankAccount(createAccount());

        return card;
    }

    BankAccount createAccount() {
        BankAccount account=new BankAccount();
        account.setBalance(3000);

        return account;
    }

}
