package za.co.emmtapp.erpservice.registration.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.PersonalDetails;
import za.co.emmtapp.erpservice.application.repos.PersonalDetailsRepository;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;
import za.co.emmtapp.erpservice.exceptions.SubscriptionAlreadyExistException;
import za.co.emmtapp.erpservice.registration.model.Course;
import za.co.emmtapp.erpservice.registration.model.Intake;
import za.co.emmtapp.erpservice.registration.model.UserCourse;
import za.co.emmtapp.erpservice.registration.model.dto.UserDTO;
import za.co.emmtapp.erpservice.registration.model.User;
import za.co.emmtapp.erpservice.registration.repository.CourseRepository;
import za.co.emmtapp.erpservice.registration.repository.IntakeRepository;
import za.co.emmtapp.erpservice.registration.repository.UserCourseRepository;
import za.co.emmtapp.erpservice.registration.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    private final CourseRepository courseRepository;

    private final IntakeRepository intakeRepository;

    private final UserCourseRepository userCourseRepository;


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
    public void registerUserForCourse(long userId, long courseId, long intakeId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with id: " + userId + " not found!")
        );

        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course with id: " + courseId + " not found!")
        );

        Intake intake = intakeRepository.findById(intakeId).orElseThrow(
                () -> new ResourceNotFoundException("Intake with id: " + intakeId + " not found!")
        );

        Optional<UserCourse> existingSubscription = userCourseRepository.findByUserIdAndCourseId(userId, courseId);

        if (existingSubscription.isPresent()) {
            throw new SubscriptionAlreadyExistException("User " + userId + " is already subscribed to course " + courseId);
        } else {
            course.setEnrolledUsers(course.getEnrolledUsers() + 1);
            courseRepository.save(course);
            UserCourse userCourse = new UserCourse(userId, courseId);
            userCourseRepository.save(userCourse);
        }
    }


    private User mapApplicantToUser(PersonalDetails applicant) {
        // Map applicant information to user fields
        User user = new User();
        BeanUtils.copyProperties(applicant, user);

        return user;
    }
}
