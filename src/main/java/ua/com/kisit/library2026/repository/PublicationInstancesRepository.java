package ua.com.kisit.library2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.library2026.entity.PublicationInstances;

import java.util.List;
import java.util.Optional;

public interface PublicationInstancesRepository extends JpaRepository<PublicationInstances, Long> {
    // 1. Знайти екземпляр за інвентарним номером (для бібліотекаря)
    Optional<PublicationInstances> findByInventoryNumber(String inventoryNumber);

    // 2. Знайти всі доступні (AVAILABLE) екземпляри конкретної книги
    // Це потрібно, щоб показати користувачу: "Є в наявності: 3 шт."
    List<PublicationInstances> findByPublication_IdAndStatus(Long publicationId, String status);

    // 3. Знайти всі книги в конкретному залі (наприклад, для інвентаризації)
    List<PublicationInstances> findByLocation(String location);
}
