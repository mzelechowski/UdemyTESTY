package pl.lomianki.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    @Test
    public void newAccountShouldNotBeActiveAfterCreation(){
        Account newAccount = new Account();
        assertFalse(newAccount.isActive());
    }
    @Test
    public void accountShouldBeActiveAfterActivation(){
        Account newAccount = new Account();
        newAccount.activate();
        assertTrue(newAccount.isActive());
    }
}
