package za.co.emmtapp.erpservice.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.emmtapp.erpservice.registration.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
