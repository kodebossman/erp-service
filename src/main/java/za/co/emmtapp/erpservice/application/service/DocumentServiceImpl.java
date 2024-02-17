package za.co.emmtapp.erpservice.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.Documentation;
import za.co.emmtapp.erpservice.application.repos.DocumentationRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentationRepository documentationRepository;
    @Override
    public Documentation createDocumentation(Documentation documentation) {
        return documentationRepository.save(documentation);
    }
}
