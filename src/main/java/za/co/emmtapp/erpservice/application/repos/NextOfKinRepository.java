package za.co.emmtapp.erpservice.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.emmtapp.erpservice.application.model.NextOfKin;

import java.util.Optional;

public interface NextOfKinRepository extends JpaRepository<NextOfKin,Long> {
    Optional<NextOfKin> findByApplicantId(Long applicantId);
}
