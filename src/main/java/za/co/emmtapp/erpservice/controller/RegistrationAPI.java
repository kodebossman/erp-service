package za.co.emmtapp.erpservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import za.co.emmtapp.erpservice.registration.model.dto.UserDTO;
import za.co.emmtapp.erpservice.registration.service.RegistrationService;

@AllArgsConstructor
@RestController
@RequestMapping("/register")
public class RegistrationAPI {

    private final RegistrationService registrationService;

    @PostMapping("/{applicationId}")
    public UserDTO registerUser(@PathVariable String applicationId, @RequestBody UserDTO userDTO) {
        return registrationService.registerUser(applicationId, userDTO);
    }

    @PostMapping("/course")
    public void registerUserForCourse(@RequestParam Long userId, @RequestParam long intakeId) {
        registrationService.enrollUserInCourse(userId, intakeId);
    }

    @PostMapping("/addModule")
    public void addModuleToEnrolment (@RequestParam Long enrolmentId, @RequestParam long moduleId) {
        registrationService.addModuleToEnrollment(enrolmentId, moduleId);
    }

}
