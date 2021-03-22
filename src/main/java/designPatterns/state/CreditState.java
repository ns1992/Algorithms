package designPatterns.state;

public class CreditState implements ATMState {

    private final ATM atm;

    public CreditState(final ATM atm) {
        this.atm = atm;
    }

    @Override
    public void withdraw(final int amount) {
        atm.removeMoney(amount);
        if (atm.getBalance() < 0) {
            atm.setState(new OverdrawnState(atm));
        }
    }

    @Override
    public void deposit(final int amount) {
        atm.addMoney(amount);
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
