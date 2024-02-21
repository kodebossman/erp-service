package za.co.emmtapp.erpservice.application.service;

import za.co.emmtapp.erpservice.application.model.EmploymentDetails;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;
import za.co.emmtapp.erpservice.application.model.dto.EmploymentDetailsDTO;

public interface EmploymentDetailsService {
    public EmploymentDetailsDTO create(EmploymentDetailsDTO employmentDetailsDTO);
    EmploymentDetailsDTO find(String id);

    public boolean update(EmploymentDetailsDTO employmentDetailsDTO);
    public boolean delete(String id);

}
