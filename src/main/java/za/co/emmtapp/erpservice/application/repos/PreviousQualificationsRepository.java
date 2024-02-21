package za.co.emmtapp.erpservice.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.emmtapp.erpservice.application.model.PreviousQualifications;

import java.util.Optional;

public interface PreviousQualificationsRepository extends JpaRepository<PreviousQualifications, Long> {
    Optional<PreviousQualifications> findByOwnerId(String ownerId);

    void deleteByOwnerId(String id);
}
