package ua.com.kisit.library2026.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.library2026.entity.PublicationInstances;
import ua.com.kisit.library2026.repository.PublicationInstancesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicationInstancesService {

    private final PublicationInstancesRepository publicationInstancesRepository;

    public List<PublicationInstances> findFirstByPublication_IdAndStatus(Long publicationId, String status) {
        return publicationInstancesRepository.findFirstByPublication_IdAndStatus(publicationId, status);
    }
    public long countByPublication_IdAndStatus(Long publicationId, String status) {
        return publicationInstancesRepository.countByPublication_IdAndStatus(publicationId, status);
    }

    public void save(PublicationInstances instance) {
        publicationInstancesRepository.save(instance);
    }
}
