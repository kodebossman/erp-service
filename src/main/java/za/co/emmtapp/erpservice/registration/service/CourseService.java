package za.co.emmtapp.erpservice.registration.service;

import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.registration.model.Module;
import za.co.emmtapp.erpservice.registration.model.dto.CourseDTO;

public interface CourseService {
    CourseDTO create(CourseDTO courseDTO);

    CourseDTO find(Long id);

    boolean update(CourseDTO courseDTO);

    boolean delete(Long id);

    CourseDTO registerUserForCourse(Long courseId, Long userId);

    Module registerModulesForCourse(Long courseId, Long userId);


    PaginationResult<CourseDTO> findAll(String search, Integer page, Integer size, String sortBy);
}