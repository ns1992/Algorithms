package designPatterns.state;

public class ATM implements ATMState {
    private ATMState state;
    private int balance;

    public ATM() {
        this.state = new CreditState(this);
    }

    void addMoney(final int amount) {
        this.balance += amount;
        System.out.println("Added " + amount + " - total " + balance);
    }

    void removeMoney(final int amount) {
        this.balance -= amount;
        System.out.println("Removed " + amount + " - total " + balance);
    }

    @Override
    public void withdraw(final int amount) {
        this.state.withdraw(amount);
    }

    @Override
    public void deposit(final int amount) {
        state.deposit(amount);
    }

    public int getBalance() {
        return balance;
    }

    public void setState(final ATMState state) {
        System.out.println("Changing state to " + state.toString());
        this.state = state;
    }

    public ATMState getState() {
        return state;
    }
}
