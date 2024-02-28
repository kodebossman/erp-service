package za.co.emmtapp.erpservice.application.service;

import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;

import java.util.List;

public interface DocumentService {
    DocumentationDTO create(DocumentationDTO documentation);

    DocumentationDTO find(String id);

    boolean update(DocumentationDTO documentationDTO);

    boolean delete(String id);

    List<DocumentationDTO> findAllByOwnerId(String ownerId);
}
