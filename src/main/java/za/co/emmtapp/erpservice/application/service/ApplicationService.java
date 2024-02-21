package za.co.emmtapp.erpservice.application.service;


import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;
import za.co.emmtapp.erpservice.common.PaginationResult;



public interface ApplicationService {
    ApplicationDTO createRegistration(ApplicationDTO applicationDTO);
    ApplicationDTO find(String id);

    boolean delete(String id);

    ApplicationDTO update(ApplicationDTO applicationDTO);

    PaginationResult<ApplicationDTO> findAll(String search, Integer page, Integer size, String sortBy);
}
