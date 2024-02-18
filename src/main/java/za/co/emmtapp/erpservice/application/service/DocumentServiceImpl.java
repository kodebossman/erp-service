package za.co.emmtapp.erpservice.application.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.Documentation;
import za.co.emmtapp.erpservice.application.repos.DocumentationRepository;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    private final DocumentationRepository documentationRepository;

    public DocumentServiceImpl(DocumentationRepository documentationRepository) {
        this.documentationRepository = documentationRepository;
    }

    @Override
    public Documentation createDocumentation(Documentation documentation) {
        return documentationRepository.save(documentation);
    }
}
