package ATMLLD;

import javax.print.attribute.standard.MediaSize;

public class HasCardState extends ATMState{
    public HasCardState() {
        System.out.println("Enter your card pin number");
    }

    @Override
    public void authenticatePin(ATM atm,Card card,String pin) {
        boolean isCorrectPinEntered=card.isCorrectPinEntered(pin);

        if (isCorrectPinEntered) {
            atm.setATMState(new SelectOperationState());
        } else {
            System.out.println("Invalid pin number");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setATMState(new IdleState());
        System.out.println("Exited...");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
