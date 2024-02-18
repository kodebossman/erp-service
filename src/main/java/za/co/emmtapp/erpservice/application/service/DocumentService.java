package za.co.emmtapp.erpservice.application.service;

import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;

public interface DocumentService {
    public DocumentationDTO create(DocumentationDTO documentation);

    DocumentationDTO find(Long id);

    public boolean update(DocumentationDTO documentationDTO);

    public boolean delete(Long id);

}
