package za.co.emmtapp.erpservice.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.emmtapp.erpservice.registration.model.UserCourse;

import java.util.Optional;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
    Optional<UserCourse> findByUserIdAndCourseId(long userId, long courseId);
}
