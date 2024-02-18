package za.co.emmtapp.erpservice.application.service;


import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;
import za.co.emmtapp.erpservice.common.PaginationResult;



public interface ApplicationService {
    ApplicationDTO createRegistration(ApplicationDTO applicationDTO);
    ApplicationDTO find(Long id);

    public boolean deleteApplication(Long id);

    public ApplicationDTO updateApplication(ApplicationDTO applicationDTO);

    public PaginationResult<ApplicationDTO> findAll(String search, Integer page, Integer size, String sortBy);
}
