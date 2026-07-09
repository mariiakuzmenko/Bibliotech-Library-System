package ua.com.kisit.library2026.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.library2026.entity.Reservations;
import ua.com.kisit.library2026.repository.ReservationsRepository;

@Service
@RequiredArgsConstructor
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;

    public void saveNewReservations(Reservations reservations) {
        reservationsRepository.save(reservations);
    }

    public Reservations findById(long id) {
        return reservationsRepository.findById(id).get();
    }

}
