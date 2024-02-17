package za.co.emmtapp.erpservice.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.emmtapp.erpservice.application.model.PreviousQualifications;

public interface PreviousQualificationsRepository extends JpaRepository<PreviousQualifications, Long> {
}
