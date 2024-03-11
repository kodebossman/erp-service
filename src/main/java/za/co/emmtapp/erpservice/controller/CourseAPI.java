package za.co.emmtapp.erpservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.emmtapp.erpservice.common.ApiResponse;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.registration.model.dto.CourseDTO;
import za.co.emmtapp.erpservice.registration.service.CourseService;

import static za.co.emmtapp.erpservice.common.ApiConstants.*;

@AllArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseAPI {

    private final CourseService courseService;

    @PostMapping("/create")
    public ApiResponse<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        CourseDTO savedCourse = courseService.create(courseDTO);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, savedCourse);
    }

    @PutMapping("/update")
    public ApiResponse<CourseDTO> update(@RequestBody CourseDTO courseDTO) {
        CourseDTO savedCourseDTO = courseService.update(courseDTO);
        return new ApiResponse<>(UPDATE_SUCCESS, APP_UPDATE_MESSAGE, savedCourseDTO);
    }

    @GetMapping("/{id}")
    public ApiResponse<CourseDTO> findCourse(@PathVariable Long id) {
        CourseDTO courseDTO = courseService.find(id);
        return new ApiResponse<>(HttpStatus.OK.value(), APP_RETRIEVE_SUCCESS, courseDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteCourse(@PathVariable Long id) {
        var deleted = courseService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), APP_DELETE_MESSAGE_SUCCESS, deleted);
    }

    @GetMapping("/all")
    public ApiResponse<PaginationResult<CourseDTO>> findAll(@RequestParam(defaultValue = "") String search,
                                                            @RequestParam(defaultValue = "1") Integer page,
                                                            @RequestParam(defaultValue = "10") Integer size,
                                                            @RequestParam(defaultValue = "id") String sortBy) {
        var res = courseService.findAll(search, page, size, sortBy);
        return new ApiResponse<>(HttpStatus.OK.value(),  APP_RETRIEVE_SUCCESS, res);
    }
}