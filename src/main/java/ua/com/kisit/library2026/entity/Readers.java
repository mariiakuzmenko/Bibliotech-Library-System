package ua.com.kisit.library2026.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString(exclude = {"user", "reservations"}) // Виключаємо зв'язки
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "libraryCardNumber") // Унікальний ключ

@Entity
@Table(name = "readers")
public class Readers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libraryCardNumber; // Номер читацької картки
    private Date openedDate; // Коли читач приєднався до бібліотеки
    private double balance = 0.0; // Для штрафів за несвоєчасне повернення літератури до бібліотеки

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    // Асоціація 1-до-1: цей профіль читача належить одному юзеру
    private Users user;

    @OneToMany(mappedBy = "reader")
    // Асоціація 1-до-багатьох: один читач може мати багато резервацій
    private List<Reservations> reservations = new ArrayList<>();
}
