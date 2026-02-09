package ua.com.kisit.library2026.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString(exclude = {"category", "publisher", "instances", "authors", "genres"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "isbn") // ISBN - ідеальний унікальний ключ


@Entity
@Table(name = "publications")
public class Publications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn; // International Standard Book Number
    private Date publicationDate;
    private String summary;
    private String language;
    private int numberOfPages;
    private String image;

    // Асоціація багато-до-1: багато публікацій належать одній категорії
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    // Асоціація багато-до-1: багато публікацій належать одному видавництву
    private Publishers publisher;

    @OneToMany(mappedBy = "publication")
    // Асоціація 1-до-багатьох: одна публікація (концепція) має багато фізичних екземплярів
    private List<PublicationInstances> instances;

    @ManyToMany
    // Асоціація багато-до-багатьох: одну публікацію можуть написати багато авторів
    private Set<Authors> authors = new HashSet<>();

    @ManyToMany
    // Асоціація багато-до-багатьох: одна публікація може належати багатьом жанрам
    private Set<Genres> genres = new HashSet<>();

}
