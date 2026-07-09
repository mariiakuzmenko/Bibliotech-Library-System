package ua.com.kisit.library2026.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.library2026.entity.Genres;
import ua.com.kisit.library2026.repository.GenresRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenresService {
    private final GenresRepository genresRepository;

    public List<Genres> findAllGenres() {
        return genresRepository.findAll();
    }
    public Genres findGenresById(Long id) {
        return genresRepository.findById(id).get();
    }
    public void saveNewGenres(Genres genres) {
        genresRepository.save(genres);
    }
    public void deleteById(Long id) {
        genresRepository.deleteById(id);
    }
    public void deleteAllGenres() {
        genresRepository.deleteAll();
    }
    public void deleteGenres(Genres genres) {
        genresRepository.delete(genres);
    }
    public void updateGenres(Genres genres) {
        genresRepository.save(genres);
    }
    public Optional<Genres> findGenresByNameIgnoreCase(String name) {
        return genresRepository.findByNameIgnoreCase(name);
    }
}
