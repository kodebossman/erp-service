package za.co.emmtapp.erpservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.emmtapp.erpservice.common.ApiResponse;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.registration.model.dto.CourseDTO;
import za.co.emmtapp.erpservice.registration.model.dto.UserDTO;
import za.co.emmtapp.erpservice.registration.service.CourseService;
import za.co.emmtapp.erpservice.registration.service.UserService;

import static za.co.emmtapp.erpservice.common.ApiConstants.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserAPI {

    private final UserService userService;


    @GetMapping("/{id}")
    public ApiResponse<UserDTO> findCourse(@PathVariable Long id) {
        UserDTO userDTO = userService.find(id);
        return new ApiResponse<>(HttpStatus.OK.value(), APP_RETRIEVE_SUCCESS, userDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteCourse(@PathVariable Long id) {
        var deleted = userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), APP_DELETE_MESSAGE_SUCCESS, deleted);
    }

    @GetMapping("/all")
    public ApiResponse<PaginationResult<UserDTO>> findAll(@RequestParam(defaultValue = "") String search,
                                                            @RequestParam(defaultValue = "1") Integer page,
                                                            @RequestParam(defaultValue = "10") Integer size,
                                                            @RequestParam(defaultValue = "id") String sortBy) {
        var res = userService.findAll(search, page, size, sortBy);
        return new ApiResponse<>(HttpStatus.OK.value(),  APP_RETRIEVE_SUCCESS, res);
    }
}