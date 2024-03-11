package za.co.emmtapp.erpservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.emmtapp.erpservice.common.ApiResponse;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.registration.model.dto.IntakeDTO;
import za.co.emmtapp.erpservice.registration.service.IntakeService;

import static za.co.emmtapp.erpservice.common.ApiConstants.*;

@AllArgsConstructor
@RestController
@RequestMapping("/intake")
public class IntakeAPI {

    private final IntakeService intakeService;

    @PostMapping("/create")
    public ApiResponse<IntakeDTO> createIntake(@RequestBody IntakeDTO intakeDTO) {
        IntakeDTO savedIntakeDTO = intakeService.create(intakeDTO);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, savedIntakeDTO);
    }

    @PutMapping("/update")
    public ApiResponse<IntakeDTO> update(@RequestBody IntakeDTO intakeDTO) {
        IntakeDTO savedIntakeDTO = intakeService.update(intakeDTO);
        return new ApiResponse<>(UPDATE_SUCCESS, APP_UPDATE_MESSAGE, savedIntakeDTO);
    }

    @GetMapping("/{id}")
    public ApiResponse<IntakeDTO> findCourse(@PathVariable Long id) {
        IntakeDTO intakeDTO = intakeService.find(id);
        return new ApiResponse<>(HttpStatus.OK.value(), APP_RETRIEVE_SUCCESS, intakeDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteCourse(@PathVariable Long id) {
        var deleted = intakeService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), APP_DELETE_MESSAGE_SUCCESS, deleted);
    }

    @GetMapping("/all")
    public ApiResponse<PaginationResult<IntakeDTO>> findAll(@RequestParam(defaultValue = "") String search,
                                                            @RequestParam(defaultValue = "1") Integer page,
                                                            @RequestParam(defaultValue = "10") Integer size,
                                                            @RequestParam(defaultValue = "id") String sortBy) {
        var res = intakeService.findAll(search, page, size, sortBy);
        return new ApiResponse<>(HttpStatus.OK.value(),  APP_RETRIEVE_SUCCESS, res);
    }
}