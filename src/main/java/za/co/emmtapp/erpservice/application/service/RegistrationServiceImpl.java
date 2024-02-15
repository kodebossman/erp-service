package za.co.emmtapp.erpservice.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional

public class RegistrationServiceImpl implements RegistrationService{


    @Override
    public ApplicationDTO createRegistration(ApplicationDTO applicationDTO) {
        return null;
    }


}
