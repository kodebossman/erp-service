package za.co.emmtapp.erpservice.registration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;
import za.co.emmtapp.erpservice.registration.model.Enrollment;
import za.co.emmtapp.erpservice.registration.model.Intake;
import za.co.emmtapp.erpservice.registration.model.User;
import za.co.emmtapp.erpservice.registration.repository.EnrollmentRepository;
import za.co.emmtapp.erpservice.registration.repository.IntakeRepository;
import za.co.emmtapp.erpservice.registration.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final UserRepository userRepository;

    private final IntakeRepository intakeRepository;

    private final EnrollmentRepository enrollmentRepository;

    @Override
    public void enrollUserInCourse(Long userId, Long intakeId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with id: " + userId + " Not Found")
        );

        Intake intake = intakeRepository.findById(intakeId).orElseThrow(
                () -> new ResourceNotFoundException("Intake with id: " + intakeId + " Not Found")
        );

        Enrollment enrollment = new Enrollment(userId, intakeId);
        enrollmentRepository.save(enrollment);
    }
}
