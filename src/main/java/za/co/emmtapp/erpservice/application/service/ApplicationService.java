package za.co.emmtapp.erpservice.application.service;

import org.springframework.data.domain.Pageable;
import za.co.emmtapp.erpservice.application.model.Application;
import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;
import za.co.emmtapp.erpservice.common.PaginationResult;



public interface ApplicationService {
    ApplicationDTO createRegistration(ApplicationDTO applicationDTO);
    ApplicationDTO find(Long id);

    public ApplicationDTO deleteApplication(ApplicationDTO applicationDTO);

    public ApplicationDTO updateApplication(ApplicationDTO applicationDTO);

    public PaginationResult<ApplicationDTO> findAll(String search, Integer page, Integer size, String sortBy);
}
