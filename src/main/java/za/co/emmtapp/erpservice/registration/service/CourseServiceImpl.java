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
import za.co.emmtapp.erpservice.registration.model.Module;
import za.co.emmtapp.erpservice.registration.model.User;
import za.co.emmtapp.erpservice.registration.model.UserCourse;
import za.co.emmtapp.erpservice.registration.model.dto.CourseDTO;
import za.co.emmtapp.erpservice.registration.model.dto.ModuleDTO;
import za.co.emmtapp.erpservice.registration.repository.CourseRepository;
import za.co.emmtapp.erpservice.registration.repository.ModuleRepository;
import za.co.emmtapp.erpservice.registration.repository.UserCourseRepository;
import za.co.emmtapp.erpservice.registration.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final UserRepository userRepository;

    private final ModuleRepository moduleRepository;

    @Override
    public CourseDTO create(CourseDTO courseDTO) {
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO, course);
        courseRepository.save(course);
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
    public boolean update(CourseDTO courseDTO) {
        boolean isUpdated = false;

//        if (courseDTO != null) {
//            Course course = courseRepository.findById(courseDTO.ge).orElseThrow(
//                    () -> new ResourceNotFoundException("application with provided Id not found")
//            );
//
//            BeanUtils.copyProperties(documentationDTO, documentation);
//
//            documentationRepository.save(documentation);
//            isUpdated = true;
//        }
        return isUpdated;
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

    public CourseDTO registerUserForCourse(Long courseId, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with the given ID was not found")
        );

        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course with the given ID was not found")
        );

        course.enrolUserInCourse(user);
        courseRepository.save(course);

        CourseDTO courseDTO = new CourseDTO();
        BeanUtils.copyProperties(course, courseDTO);
        return courseDTO;
    }

    @Override
    public Module registerModulesForCourse(Long moduleId, Long courseId) {
        Module module = moduleRepository.findById(moduleId).orElseThrow(
                () -> new ResourceNotFoundException("Module with the given ID was not found")
        );

        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course with the given ID was not found")
        );

        module.setCourse(course);

        return moduleRepository.save(module);
    }

    private CourseDTO convertToCourseDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCapacity(course.getCapacity());
//        courseDTO.setEnrolledUsers(course.getEnrolledUsers());

        return courseDTO;
    }
}
