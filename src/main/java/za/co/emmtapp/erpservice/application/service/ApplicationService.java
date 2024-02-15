package za.co.emmtapp.erpservice.application.service;

import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;

public interface ApplicationService {
    ApplicationDTO createRegistration(ApplicationDTO applicationDTO);
}
