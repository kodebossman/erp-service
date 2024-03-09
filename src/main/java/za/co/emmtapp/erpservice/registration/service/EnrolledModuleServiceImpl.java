package za.co.emmtapp.erpservice.registration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.registration.model.EnrolledModule;
import za.co.emmtapp.erpservice.registration.repository.EnrolledModuleRepository;

@Service
@RequiredArgsConstructor
public class EnrolledModuleServiceImpl implements EnrolledModuleService {

    private final EnrolledModuleRepository enrolledModuleRepository;
    @Override
    public void addModuleToEnrollment(Long enrollmentId, Long moduleId) {
        EnrolledModule enrolledModule = new EnrolledModule(enrollmentId, moduleId);
        enrolledModuleRepository.save(enrolledModule);
    }
}
