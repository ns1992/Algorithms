package designPatterns.state;

public class OverdrawnState implements ATMState {

    private final ATM atm;

    public OverdrawnState(final ATM atm) {
        this.atm = atm;
    }

    @Override
    public void withdraw(final int amount) {
        System.out.println("Error - no money!");
    }

    @Override
    public void deposit(final int amount) {
        atm.addMoney(amount);
        if (atm.getBalance() >= 0) {
            atm.setState(new CreditState(atm));
        }
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
