package ua.com.kisit.library2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.library2026.entity.Reservations;

import java.util.Date;
import java.util.List;

public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
    // 1. Знайти всі книги, які зараз на руках у конкретного читача
    List<Reservations> findByReader_IdAndReturnDateIsNull(Long readerId);

    // 2. Знайти всі прострочені книги (дата повернення менша за сьогодні, і книга ще не повернута)
    // Це для розрахунку штрафів
    List<Reservations> findByDueDateBeforeAndReturnDateIsNull(Date today);

    // 3. Історія видачі конкретної фізичної книги (хто її читав раніше)
    List<Reservations> findByPublicationInstance_InventoryNumber(String inventoryNumber);

    // 4. Знайти всі активні резервації (для адміна)
    List<Reservations> findByStatus(String status);
}
