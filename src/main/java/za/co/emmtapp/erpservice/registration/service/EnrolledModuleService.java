package za.co.emmtapp.erpservice.registration.service;

public interface EnrolledModuleService {
    void addModuleToEnrollment(Long enrollmentId, Long moduleId);
}
