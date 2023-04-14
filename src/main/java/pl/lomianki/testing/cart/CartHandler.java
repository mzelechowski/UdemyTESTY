package pl.lomianki.testing.cart;

public interface CartHandler {
    boolean canHandlerCart(Cart cart);
    void sendToPrepare(Cart cart);
}
