package ATMLLD;

public class IdleState extends ATMState {
    @Override
    public void insertCard(ATM atm,Card card) {
        System.out.println("Card is inserted");
        atm.setATMState(new HasCardState());
    }
}
