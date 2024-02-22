package za.co.emmtapp.erpservice.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.emmtapp.erpservice.application.model.Documentation;
import za.co.emmtapp.erpservice.review.model.ApplicationReview;

import java.util.Optional;

@Repository
public interface ApplicationReviewRepository extends JpaRepository<ApplicationReview, Long> {
    Optional<ApplicationReview> findByApplicationId(String id);
}
