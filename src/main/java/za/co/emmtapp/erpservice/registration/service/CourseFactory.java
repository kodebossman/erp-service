package za.co.emmtapp.erpservice.registration.service;

import za.co.emmtapp.erpservice.registration.model.Course;
import za.co.emmtapp.erpservice.registration.model.CourseType;

public interface CourseFactory {
    Course createCourse(CourseType type);
}
