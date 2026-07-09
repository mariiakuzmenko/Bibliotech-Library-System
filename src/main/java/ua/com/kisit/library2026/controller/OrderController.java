package ua.com.kisit.library2026.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.kisit.library2026.bl.Cart;
import ua.com.kisit.library2026.bl.ReservationCart;
import ua.com.kisit.library2026.entity.*;
import ua.com.kisit.library2026.service.PublicationInstancesService;
import ua.com.kisit.library2026.service.ReadersService;
import ua.com.kisit.library2026.service.ReservationsService;
import ua.com.kisit.library2026.service.UsersService;

import java.util.Calendar;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final ReservationsService reservationsService;
    private final UsersService usersService;
    private final ReadersService readersService;
    private final PublicationInstancesService publicationInstancesService;

    @GetMapping("/order")
    public String getPageOrder(Model model,
                               HttpServletRequest request){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = (Users) usersService.loadUserByUsername(authentication.getName());

        Users users = usersService.findById(user.getId());

        model.addAttribute("user",user);

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            return "redirect:/";
        }

        if(cart.getCart().size()==0){
            return "redirect:/";
        }

        model.addAttribute("cart",cart);
        model.addAttribute("el", cart.getSumItem());

        return "order";
    }

    @PostMapping("/buy")
    public String confirmReservation(@RequestParam(name = "pick-up") String pickUp,
                                     @RequestParam(name = "time") int time,
                                     HttpServletRequest request,
                                     RedirectAttributes redirectAttributes) {

        // 1. Отримуємо поточного користувача і його профіль читача
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = (Users) usersService.loadUserByUsername(auth.getName());

        // Знаходимо читача за ID юзера (якщо використовували Optional, додайте .orElse(null))
        Readers reader = readersService.findByUser_Id(user.getId());
        if (reader == null) {
            return "redirect:/registration";
        }

        // 2. Отримуємо кошик
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getCart().isEmpty()) {
            return "redirect:/catalog";
        }

        // 3. Перевірка наявності
        for (ReservationCart item : cart.getCart()) {
            Publications pub = item.getPublications();
            long availableCount = publicationInstancesService.countByPublication_IdAndStatus(pub.getId(), "Available");

            if (availableCount < 1) {
                redirectAttributes.addAttribute("error", "Книга '" + pub.getTitle() + "' зараз недоступна. Всі екземпляри зайняті.");
                return "redirect:/cart";
            }
        }

        // 4. Розрахунок дати повернення (14 або 30 днів)
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        if (time == 1) {
            calendar.add(Calendar.DAY_OF_MONTH, 14);
        } else if (time == 2) {
            calendar.add(Calendar.DAY_OF_MONTH, 30);
        }
        Date dueDate = calendar.getTime();

        String pickUpMethodText = pickUp.equals("1") ? "Pickup" : "Reading room";

        // Бронюємо фізичні екземпляри
        for (ReservationCart item : cart.getCart()) {
            Publications pub = item.getPublications();

            // Знаходимо перший вільний екземпляр цієї книги
            PublicationInstances instance = publicationInstancesService
                    .findFirstByPublication_IdAndStatus(pub.getId(), "Available")
                    .get(0);

            // ЗМІНЮЄМО СТАТУС ЕКЗЕМПЛЯРА
            instance.setStatus("Reserved"); // Або "RESERVED"
            publicationInstancesService.save(instance);

            // СТВОРЮЄМО ЗАПИС ПРО БРОНЮВАННЯ
            Reservations reservation = new Reservations();
            reservation.setReader(reader);
            reservation.setPublicationInstance(instance);
            reservation.setStatus("Active");
            reservation.setReservationDate(now);
            reservation.setDueDate(dueDate);
            reservation.setPickUpMethod(pickUpMethodText);

            reservationsService.saveNewReservations(reservation);
        }

        //  Очищаємо кошик після успішного оформлення
        cart.getCart().clear();
        session.setAttribute("cart", cart);

        redirectAttributes.addAttribute("message", "Your books are successfully reserved until " + dueDate.toString());
        return "redirect:/thank";
    }


    @GetMapping("/thank")
    public String getThankPage(@RequestParam(name = "message", defaultValue = " ") String info,
                               @RequestParam(name = "id_order", defaultValue= " ") Long id,
                               Model model) {

        model.addAttribute("info", info);
        model.addAttribute("id_order", id);

        return "thank";
    }

}
