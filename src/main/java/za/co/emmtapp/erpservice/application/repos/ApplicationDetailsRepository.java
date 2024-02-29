package za.co.emmtapp.erpservice.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.emmtapp.erpservice.application.model.ApplicationDetails;

import java.util.List;

@Repository
public interface ApplicationDetailsRepository extends JpaRepository<ApplicationDetails, Long> {
    List<ApplicationDetails> findAllByApplicationId(String applicationId);
}
