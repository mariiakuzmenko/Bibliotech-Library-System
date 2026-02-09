package ua.com.kisit.library2026.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = {"publication", "reservations"})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "inventoryNumber") // Інв. номер - унікальний

@Entity
@Table(name = "publication_instances")
public class PublicationInstances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inventoryNumber; // Інвентарний номер
    private String status; // "Доступна", "Зарезервована", "На руках"
    private String location; // "Абонемент", "Читальний зал"
    private String book_condition; // "Нова", "Добра", "Потребує ремонту"

    @ManyToOne
    @JoinColumn(name = "publication_id")
    // Асоціація багато-до-1: багато екземплярів належать одній публікації (концепції)
    private Publications publication;

    @OneToMany(mappedBy = "publicationInstance")
    // Асоціація 1-до-багатьох: один екземпляр може мати багато резервацій (історія)
    private List<Reservations> reservations;
}
