package za.co.emmtapp.erpservice.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.emmtapp.erpservice.application.model.ApplicationDetails;


@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationDetails,Long> {

}
