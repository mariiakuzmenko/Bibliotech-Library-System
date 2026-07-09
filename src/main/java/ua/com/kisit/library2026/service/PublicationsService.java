package ua.com.kisit.library2026.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.library2026.entity.Categories;
import ua.com.kisit.library2026.entity.Genres;
import ua.com.kisit.library2026.entity.Publications;
import ua.com.kisit.library2026.repository.PublicationsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublicationsService {
    private final PublicationsRepository publicationsRepository;
    public Optional<Publications> findByIsbn(String isbn) {
        return publicationsRepository.findByIsbn(isbn);
    }
    public List<Publications> findByTitleContainingIgnoreCase(String title) {
        return publicationsRepository.findByTitleContainingIgnoreCase(title);
    }
    public List<Publications> findByCategory(Categories category) {
        return publicationsRepository.findByCategory(category);
    }
    public List<Publications> findByAuthors_LastNameIgnoreCase(String lastName) {
        return publicationsRepository.findByAuthors_LastNameIgnoreCase(lastName);
    }
    public List<Publications> findByGenresContaining(Genres genres) {
        return publicationsRepository.findByGenresContaining(genres);
    }
    public List<Publications> findTop10ByOrderByPublicationDateDesc() {
        return publicationsRepository.findTop10ByOrderByPublicationDateDesc();
    }
    public List<Publications> findAllPublications() {
        return publicationsRepository.findAll();
    }
    public Publications findById(Long id) {
        return publicationsRepository.findById(id).get();
    }
    public void saveNewPublications(Publications publications) {
        publicationsRepository.save(publications);
    }
    public void deleteById(Long id) {
        publicationsRepository.deleteById(id);
    }
    public void deleteAll(){
        publicationsRepository.deleteAll();
    }
    public void deletePublications(Publications publications) {
        publicationsRepository.delete(publications);
    }
    public void updatePublications(Publications publications) {
        publicationsRepository.save(publications);
    }

}
