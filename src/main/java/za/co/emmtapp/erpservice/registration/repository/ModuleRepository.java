package za.co.emmtapp.erpservice.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.emmtapp.erpservice.registration.model.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
