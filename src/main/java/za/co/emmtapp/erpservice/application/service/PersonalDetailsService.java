package za.co.emmtapp.erpservice.application.service;

import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;
import za.co.emmtapp.erpservice.application.model.dto.EmploymentDetailsDTO;
import za.co.emmtapp.erpservice.application.model.dto.NextOfKinDTO;
import za.co.emmtapp.erpservice.application.model.dto.PersonalDetailsDTO;

public interface PersonalDetailsService {
    PersonalDetailsDTO create(PersonalDetailsDTO personalDetailsDTO);
    boolean update(PersonalDetailsDTO personalDetailsDTO);
    PersonalDetailsDTO find(String idNumber);

    boolean delete(String id);

}
