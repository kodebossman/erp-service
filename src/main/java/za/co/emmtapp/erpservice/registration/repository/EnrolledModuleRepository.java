package za.co.emmtapp.erpservice.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.emmtapp.erpservice.registration.model.EnrolledModule;

public interface EnrolledModuleRepository extends JpaRepository<EnrolledModule, Long> {

}
