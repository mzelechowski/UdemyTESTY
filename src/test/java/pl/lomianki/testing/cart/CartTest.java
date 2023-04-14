package pl.lomianki.testing.cart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.lomianki.testing.Meal;
import pl.lomianki.testing.cart.Cart;
import pl.lomianki.testing.order.Order;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToCart() {
        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(), anyOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertAll("This is a group assertions for cart",
                () -> assertThat(cart.getOrders(), notNullValue()),
                () -> assertThat(cart.getOrders(), hasSize(1)),
                () -> assertThat(cart.getOrders(), is(not(empty()))),
                () -> assertThat(cart.getOrders(), is(not(emptyCollectionOf(Order.class)))),
                // () -> assertThat(cart.getOrders().get(0).getMeals(), empty())
                () -> {
                    List<Meal> meals = cart.getOrders().get(0).getMeals();
                    assertThat(meals, emptyCollectionOf(Meal.class));
                }
        );
    }
}