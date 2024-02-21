package za.co.emmtapp.erpservice.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.emmtapp.erpservice.application.model.Application;


@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
    void deleteByIdNumber(String idNumber);
    Application findApplicationByIdNumber(String idNumber);
}
