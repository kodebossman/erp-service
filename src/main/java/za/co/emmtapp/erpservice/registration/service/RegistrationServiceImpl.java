package za.co.emmtapp.erpservice.registration.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.PersonalDetails;
import za.co.emmtapp.erpservice.application.repos.PersonalDetailsRepository;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;
import za.co.emmtapp.erpservice.registration.model.dto.UserDTO;
import za.co.emmtapp.erpservice.registration.model.User;
import za.co.emmtapp.erpservice.registration.repository.*;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    private final EnrollmentService enrollmentService;

    private final EnrolledModuleService enrolledModuleService;

    private final PersonalDetailsRepository personalDetailsRepository;
    @Override
    public UserDTO registerUser(String applicationId, UserDTO userDTO) {

        PersonalDetails applicant = personalDetailsRepository.findByIdNumber(applicationId).orElseThrow(
                () -> new ResourceNotFoundException("Applicant Details Not Found")
        );

        if (applicant != null) {
            User user = mapApplicantToUser(applicant);
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            User savedUser = userRepository.save(user);
            BeanUtils.copyProperties(savedUser, userDTO);
        }
        return userDTO;
    }

    @Override
    public void enrollUserInCourse(Long userId, Long intakeId) {
        enrollmentService.enrollUserInCourse(userId, intakeId);
    }

    @Override
    public void addModuleToEnrollment(Long enrolmentId, Long moduleId) {
        enrolledModuleService.addModuleToEnrollment(enrolmentId, moduleId);
    }

    private User mapApplicantToUser(PersonalDetails applicant) {
        // Map applicant information to user fields
        User user = new User();
        BeanUtils.copyProperties(applicant, user);

        return user;
    }
}
