package za.co.emmtapp.erpservice.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.emmtapp.erpservice.application.model.PersonalDetails;

import java.util.Optional;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
    Optional<PersonalDetails> findByIdNumber(String idNumber);

    void deleteByIdNumber(String id);
}
