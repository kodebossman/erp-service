package za.co.emmtapp.erpservice.application.service;

import za.co.emmtapp.erpservice.application.model.dto.ApplicationDetailDTO;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;

import java.util.List;

public interface ApplicationDetailsService {
    ApplicationDetailDTO create(ApplicationDetailDTO applicationDetailDTO);
    List<ApplicationDetailDTO> findAllByApplicationId(String applicationId);
}
