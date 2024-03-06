package za.co.emmtapp.erpservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.emmtapp.erpservice.common.ApiResponse;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.registration.model.Course;
import za.co.emmtapp.erpservice.registration.model.Module;
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
        courseService.create(courseDTO);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, courseDTO);
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

    @PostMapping("/{courseId}/users/{userId}")
    public ApiResponse<CourseDTO> enrollUserToCourse(@PathVariable long courseId, @PathVariable long userId) {
        CourseDTO courseDTO = courseService.registerUserForCourse(courseId, userId);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, courseDTO);
    }

    @PostMapping("/{courseId}/modules/{moduleId}")
    public ApiResponse<Module> assignModuleToCourse(@PathVariable long courseId, @PathVariable long moduleId) {
        Module module = courseService.registerModulesForCourse(courseId, moduleId);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, module);
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