package za.co.emmtapp.erpservice.registration.service;

import za.co.emmtapp.erpservice.registration.model.dto.UserDTO;

public interface RegistrationService {
    UserDTO registerUser(String applicationId, UserDTO userDTO);

    void registerUserForCourse(long userId, long courseId, long intakeId);
}
