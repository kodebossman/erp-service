package za.co.emmtapp.erpservice.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.emmtapp.erpservice.application.model.ApplicationDetails;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationDetailsRepository extends JpaRepository<ApplicationDetails, Long> {
    Optional<ApplicationDetails> findByApplicationId(String applicationId);
}
