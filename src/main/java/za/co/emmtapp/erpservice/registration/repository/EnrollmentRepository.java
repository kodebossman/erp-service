package za.co.emmtapp.erpservice.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.emmtapp.erpservice.registration.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
