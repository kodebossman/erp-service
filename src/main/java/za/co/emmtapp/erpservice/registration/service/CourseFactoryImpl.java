package za.co.emmtapp.erpservice.registration.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.registration.model.*;

@Getter
@Setter
@Service
public class CourseFactoryImpl implements CourseFactory {
    @Override
    public Course createCourse(CourseType type) {
        return switch (type) {
            case CIMA -> new CimaCourse();
            case HIGH_SCHOOL -> new HighSchoolCourse();
            case UNIVERSITY_ACCOUNTING -> new UniversityAccountingCourse();
        };
    }
}
