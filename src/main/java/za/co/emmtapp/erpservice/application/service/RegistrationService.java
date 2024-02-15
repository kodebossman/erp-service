package za.co.emmtapp.erpservice.application.service;

import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;

public interface RegistrationService {
    ApplicationDTO createRegistration(ApplicationDTO applicationDTO);
}
