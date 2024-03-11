package za.co.emmtapp.erpservice.registration.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;
import za.co.emmtapp.erpservice.registration.model.Course;
import za.co.emmtapp.erpservice.registration.model.CourseType;
import za.co.emmtapp.erpservice.registration.model.dto.CourseDTO;
import za.co.emmtapp.erpservice.registration.repository.CourseRepository;
import za.co.emmtapp.erpservice.registration.repository.ModuleRepository;
import za.co.emmtapp.erpservice.registration.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private CourseFactory courseFactory;

    @Override
    public CourseDTO create(CourseDTO courseDTO) {
        Course course = courseFactory.createCourse(courseDTO.getCourseType());
        BeanUtils.copyProperties(courseDTO, course);
        Course savedCourse = courseRepository.save(course);
        BeanUtils.copyProperties(savedCourse, courseDTO);
        return courseDTO;
    }

    @Override
    public CourseDTO find(Long id) {
        CourseDTO courseDTO = new CourseDTO();
        Course course =  courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("application with provided Id not found")
        );
        BeanUtils.copyProperties(course, courseDTO);
        return courseDTO;
    }

    @Override
    public CourseDTO update(CourseDTO courseDTO) {
        if (courseDTO != null) {
            Course course = courseRepository.findById(courseDTO.getId()).orElseThrow(
                    () -> new ResourceNotFoundException("Course with Id " + courseDTO.getId() + " not found")
            );

            BeanUtils.copyProperties(courseDTO, course);

            Course savedCourse = courseRepository.save(course);
            BeanUtils.copyProperties(savedCourse, courseDTO);
        }
        return courseDTO;
    }

    @Override
    public boolean delete(Long id) {
        courseRepository.deleteById(id);
        return true;
    }

    @Override
    public PaginationResult<CourseDTO> findAll(String search, Integer page, Integer size, String sortBy) {
        var pageable = PageRequest.of(page - 1, size, Sort.by(sortBy));
        Page<Course> pageResult = courseRepository.findAll(pageable);

        List<CourseDTO> courseDTOs = pageResult.getContent().stream()
                .map(this::convertToCourseDto)
                .toList();

        return PaginationResult.pagination(courseDTOs, pageResult.getTotalElements(), page, size);
    }

    private CourseDTO convertToCourseDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCapacity(course.getCapacity());
        courseDTO.setCourseDescription(course.getCourseDescription());

        return courseDTO;
    }
}
