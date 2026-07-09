package ua.com.kisit.library2026.bl;


import lombok.Getter;
import lombok.Setter;
import ua.com.kisit.library2026.entity.Publications;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Cart {
    List<ReservationCart> cart;
    private int sumElCart;

    public Cart() {
        cart = new ArrayList<>();
        sumElCart = 0;
    }

    public synchronized void addNewReservationToCart(Publications publications) {
        for (ReservationCart reservationCart : cart) {
            if  (reservationCart.getPublications().getId().equals(publications.getId())) {
                return;
            }
        }
        cart.add(new ReservationCart(publications));
    }

    public synchronized void removeReservationInCart(Publications publications) {
        for (ReservationCart reservationCart : cart) {
            if (reservationCart.getPublications().getId().equals(publications.getId())) {
                cart.remove(reservationCart);
                break;
            }
        }
    }

    public synchronized void removeAllReservationsInCart(Publications publications) {
        cart.clear();
    }

    public synchronized int getSumItem() {
        return sumElCart = cart.size();
    }

}
