package za.co.emmtapp.erpservice.application.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.Documentation;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;
import za.co.emmtapp.erpservice.application.repos.DocumentationRepository;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    private final DocumentationRepository documentationRepository;

    public DocumentServiceImpl(DocumentationRepository documentationRepository) {
        this.documentationRepository = documentationRepository;
    }

    @Override
    public DocumentationDTO create(DocumentationDTO documentationDTO) {
        Documentation documentation = new Documentation();
        BeanUtils.copyProperties(documentationDTO, documentation);
        documentationRepository.save(documentation);
        return documentationDTO;
    }

    @Override
    public DocumentationDTO find(String id) {
        DocumentationDTO documentationDTO = new DocumentationDTO();
        Documentation documentation =  documentationRepository.findByOwnerId(id).orElseThrow(
                () -> new ResourceNotFoundException("application with provided Id not found")
        );
        BeanUtils.copyProperties(documentation, documentationDTO);
        return documentationDTO;
    }

    @Override
    public boolean update(DocumentationDTO documentationDTO) {
        boolean isUpdated = false;


        if (documentationDTO != null) {
            Documentation documentation = documentationRepository.findByOwnerId(documentationDTO.getOwnerId()).orElseThrow(
                    () -> new ResourceNotFoundException("application with provided Id not found")
            );

            BeanUtils.copyProperties(documentationDTO, documentation);

            documentationRepository.save(documentation);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean delete(String id) {
        documentationRepository.deleteByOwnerId(id);
        return true;
    }

    @Override
    public List<DocumentationDTO> findAllByOwnerId(String ownerId) {
        List<Documentation> docs = documentationRepository.findAllByOwnerId(ownerId);

        DocumentationDTO documentationDTO = new DocumentationDTO();
        return docs.stream().map(documentation -> mapToDocumentationDto(documentation, documentationDTO)).toList();
    }

    private DocumentationDTO mapToDocumentationDto(Documentation documentation, DocumentationDTO documentationDTO) {
        documentationDTO.setOwnerId(documentation.getOwnerId());
        documentationDTO.setDocumentName(documentation.getDocumentName());
        documentationDTO.setDocumentURL(documentation.getDocumentURL());
        documentationDTO.setDocumentType(documentation.getDocumentType());
        return documentationDTO;
    }

}
