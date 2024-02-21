package za.co.emmtapp.erpservice.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.emmtapp.erpservice.review.model.ApplicationReview;

public interface ApplicationReviewRepository extends JpaRepository<ApplicationReview, Long> {

}
