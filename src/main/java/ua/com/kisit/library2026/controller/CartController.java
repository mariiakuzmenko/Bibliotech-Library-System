package ua.com.kisit.library2026.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.library2026.bl.Cart;
import ua.com.kisit.library2026.entity.Publications;

@Controller
@RequiredArgsConstructor
public class CartController {

    @GetMapping("/cart")
    public String getCart(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        session.setAttribute("cart", cart);

        model.addAttribute("cart", cart);
        model.addAttribute("el", cart.getSumItem());

        return "cart";
    }

    @PostMapping("/addPublicationToCart")
    public String addToCart(@RequestParam(name = "id") Publications publications,
                            HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        cart.addNewReservationToCart(publications);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @PostMapping("/deleteFromCart")
    public String deleteFromCart(@RequestParam(name = "id") Publications publications,
                                  HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        cart.removeReservationInCart(publications);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @PostMapping("/removeAllReservationsInCart")
    public String removeAllReservationsInCart(Publications publications,
                                              HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeAllReservationsInCart(publications);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

}
