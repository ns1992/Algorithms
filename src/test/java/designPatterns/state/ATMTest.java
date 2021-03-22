package designPatterns.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ATMTest {

    private ATM atm;

    @BeforeEach
    public void setup() {
        this.atm = new ATM();
    }

    @Test
    public void testATMStates() {
        assertEquals(0, atm.getBalance());
        assertTrue(atm.getState() instanceof CreditState);

        atm.withdraw(10);
        assertEquals(-10, atm.getBalance());
        assertTrue(atm.getState() instanceof OverdrawnState);

        atm.deposit(10);
        assertEquals(0, atm.getBalance());
        assertTrue(atm.getState() instanceof CreditState);

        atm.withdraw(20);
        assertEquals(-20, atm.getBalance());
        assertTrue(atm.getState() instanceof OverdrawnState);

        atm.withdraw(200);
        assertEquals(-20, atm.getBalance());
        assertTrue(atm.getState() instanceof OverdrawnState);

        atm.deposit(200);
        assertEquals(180, atm.getBalance());
        assertTrue(atm.getState() instanceof CreditState);
    }
}