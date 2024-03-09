package za.co.emmtapp.erpservice.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import za.co.emmtapp.erpservice.application.model.PersonalDetails;
import za.co.emmtapp.erpservice.application.model.dto.*;

public interface PersonalDetailsService {
    PersonalDetailsDTO create(PersonalDetailsDTO personalDetailsDTO);
    boolean update(PersonalDetailsDTO personalDetailsDTO);
    PersonalDetailsDTO find(String idNumber);

    boolean delete(String id);

    Page<PersonalDetails> findAll(PageRequest pageRequest);

}
