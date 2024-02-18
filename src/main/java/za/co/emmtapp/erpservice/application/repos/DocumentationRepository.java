package za.co.emmtapp.erpservice.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.emmtapp.erpservice.application.model.Application;
import za.co.emmtapp.erpservice.application.model.Documentation;

import java.util.Optional;

public interface DocumentationRepository extends JpaRepository<Documentation, Long> {
    Optional<Documentation> findByOwnerId(Long ownerId);

}
