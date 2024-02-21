package za.co.emmtapp.erpservice.application.service;

import za.co.emmtapp.erpservice.application.model.EmploymentDetails;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;
import za.co.emmtapp.erpservice.application.model.dto.EmploymentDetailsDTO;

public interface EmploymentDetailsService {
    public EmploymentDetailsDTO create(EmploymentDetailsDTO employmentDetailsDTO);
    EmploymentDetailsDTO find(String id);

    boolean update(EmploymentDetailsDTO employmentDetailsDTO);
    boolean delete(String id);

}
