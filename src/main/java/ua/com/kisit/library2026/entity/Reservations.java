package ua.com.kisit.library2026.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status; // Наприклад: "Активна", "Закрита", "Протермінована"

    private Date reservationDate; // Коли замовили (створили резерв)
    private Date issueDate; // Коли бібліотекар видав книгу
    private Date dueDate; // До якої дати треба повернути
    private Date returnDate; // Коли фактично повернули

    @ManyToOne
    @JoinColumn(name = "reader_id")
    // Асоціація багато-до-1: багато резервацій належить одному профілю читача
    private Readers reader;

    @ManyToOne
    @JoinColumn(name = "publication_instance_id")
    // Асоціація багато-до-1: багато резервацій стосуються одного екземпляра
    private PublicationInstances publicationInstance;
}
