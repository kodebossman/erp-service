package za.co.emmtapp.erpservice.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.emmtapp.erpservice.registration.model.Intake;

@Repository
public interface IntakeRepository extends JpaRepository<Intake, Long> {
//    boolean existsById(Long intakeId);

}
