package za.co.emmtapp.erpservice.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.emmtapp.erpservice.common.ApiResponse;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.registration.model.dto.CourseDTO;
import za.co.emmtapp.erpservice.registration.model.dto.ModuleDTO;
import za.co.emmtapp.erpservice.registration.service.ModuleService;

import static za.co.emmtapp.erpservice.common.ApiConstants.*;

@AllArgsConstructor
@RestController
@RequestMapping("/modules")
public class ModuleAPI {

    private final ModuleService moduleService;

    @PostMapping("/create")
    public ApiResponse<ModuleDTO> createModule(@RequestBody ModuleDTO moduleDTO) {
        moduleService.create(moduleDTO);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, moduleDTO);
    }

    @GetMapping("/{id}")
    public ApiResponse<ModuleDTO> findModule(@PathVariable Long id) {
        ModuleDTO moduleDTO = moduleService.find(id);
        return new ApiResponse<>(HttpStatus.OK.value(), APP_RETRIEVE_SUCCESS, moduleDTO);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteModule(@PathVariable Long id) {
        var deleted = moduleService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), APP_DELETE_MESSAGE_SUCCESS, deleted);
    }

    @GetMapping("/all")
    public ApiResponse<PaginationResult<ModuleDTO>> findAll(@RequestParam(defaultValue = "") String search,
                                                            @RequestParam(defaultValue = "1") Integer page,
                                                            @RequestParam(defaultValue = "10") Integer size,
                                                            @RequestParam(defaultValue = "id") String sortBy) {
        var res = moduleService.findAll(search, page, size, sortBy);
        return new ApiResponse<>(HttpStatus.OK.value(),  APP_RETRIEVE_SUCCESS, res);
    }
}
