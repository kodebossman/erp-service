package za.co.emmtapp.erpservice.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.emmtapp.erpservice.application.model.EmploymentDetails;

import java.util.Optional;

public interface EmploymentDetailsRepository extends JpaRepository<EmploymentDetails, Long> {
    Optional<EmploymentDetails> findByApplicantId(Long id);
}
