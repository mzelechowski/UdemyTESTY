package pl.lomianki.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
// @Disabled - can be set either before class or selected test
@DisplayName("Cart is able to process 1000 orders in 100ms.")
class CartTest {
   // @Disabled -can be set either before class or selected test
    @Test
    void simulateLargeOrder() {
        //given
        Cart cart = new Cart();

        //when
        //then
//        assertTimeout(Duration.ofMillis(10),()->cart.simulateLargeOrder());
        assertTimeout(Duration.ofMillis(100), cart::simulateLargeOrder);
    }
}