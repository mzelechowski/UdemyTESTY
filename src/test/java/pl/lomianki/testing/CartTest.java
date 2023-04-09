package pl.lomianki.testing;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

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