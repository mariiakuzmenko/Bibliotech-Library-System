package ua.com.kisit.library2026.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.library2026.entity.Readers;
import ua.com.kisit.library2026.repository.ReadersRepository;

@Service
@RequiredArgsConstructor
public class ReadersService {
    private final ReadersRepository readersRepository;

    public void saveReaders(Readers readers) {
        readersRepository.save(readers);
    }

    public Readers findReadersById(Long id) {
        return readersRepository.findById(id).get();
    }

    public Readers findByUser_Id(Long id) {
        return readersRepository.findByUser_Id(id).orElse(null);
    }
}
