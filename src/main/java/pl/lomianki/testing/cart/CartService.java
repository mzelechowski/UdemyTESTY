package pl.lomianki.testing.cart;

import pl.lomianki.testing.order.OrderStatus;

public class CartService {
    private CartHandler cartHandler;

    public CartService(CartHandler cartHandler) {
        this.cartHandler = cartHandler;
    }

    Cart processCart(Cart cart){
        if(cartHandler.canHandlerCart(cart)){
            cartHandler.sendToPrepare(cart);
            cart.getOrders().forEach(order -> {order.changeOrderStatus(OrderStatus.PREPARING);});
            return cart;
        }else{
            cart.getOrders().forEach(order -> {order.changeOrderStatus(OrderStatus.REJECTED);});
            return cart;
        }
    }
}
