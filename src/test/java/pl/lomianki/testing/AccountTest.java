package pl.lomianki.testing;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Tag("fries")
public class AccountTest {
    @Test
    public void newAccountShouldNotBeActiveAfterCreation() {
        Account newAccount = new Account();
        assertFalse(newAccount.isActive());
        assertThat(newAccount.isActive(), is(false));
    }

    @Test
    public void accountShouldBeActiveAfterActivation() {
        //given
        Account newAccount = new Account();
        //when
        newAccount.activate();
        //then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive(),equalTo(true));
    }

    @Test
    public void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddress() {
        //given
        Account account = new Account();
        //when
        Address address = account.getDefaultDeliveryAddress();
        //then
        assertNull(address);
        assertThat(address, nullValue());

    }

    @Test
    public void DefaultDeliveryAddressShouldNotBeNullAfterSet() {
        //given
        Address address = new Address("Niepodległości", "1");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultDeliveryAddress = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(defaultDeliveryAddress);
        assertThat(defaultDeliveryAddress,notNullValue());
    }

    @RepeatedTest(5)
    void newAccountWithNotNullAddressShouldBeActive(){
        //given
        Address address= new Address("Warszawska", "77/7");

        //when
        Account account= new Account(address);

        //then
        assumingThat(address!=null, ()->{
            assertTrue(account.isActive());
                }
        );
    }
    @Test
    void invalidEmailShouldThrowException(){
        //given
        Account account = new Account();

        //when
        //then
        assertThrows(IllegalArgumentException.class, ()->account.setEmail("wrongEmail"));
    }
}
