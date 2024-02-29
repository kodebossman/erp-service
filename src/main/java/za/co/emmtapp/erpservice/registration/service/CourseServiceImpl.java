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
import za.co.emmtapp.erpservice.registration.model.dto.CourseDTO;
import za.co.emmtapp.erpservice.registration.repository.CourseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

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

    private CourseDTO convertToCourseDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCapacity(course.getCapacity());
        courseDTO.setEnrolledUsers(course.getEnrolledUsers());

        return courseDTO;
    }
}
