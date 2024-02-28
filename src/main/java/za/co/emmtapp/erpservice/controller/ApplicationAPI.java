package za.co.emmtapp.erpservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;
import za.co.emmtapp.erpservice.common.ApiResponse;
import za.co.emmtapp.erpservice.common.CrudApi;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.application.service.ApplicationService;

import static za.co.emmtapp.erpservice.common.ApiConstants.*;

@Tag(
        name = "CRUD REST APIs for ERP Service",
        description = "CRUD REST APIs for ERP Service Application Process to CREATE, UPDATE, FETCH AND DELETE applications"
)
@RestController
@RequestMapping("/application")
@Slf4j
public class ApplicationAPI implements CrudApi<ApplicationDTO> {

    private final ApplicationService registrationService;

    public ApplicationAPI(ApplicationService registrationService) {
        this.registrationService = registrationService;
    }


    @Override
    public ApiResponse<ApplicationDTO> create(ApplicationDTO applicationDTO) {
        ApplicationDTO app = registrationService.createRegistration(applicationDTO);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, app);
    }

    @Override
    public ApiResponse<ApplicationDTO> update(ApplicationDTO applicationDTO) {
        ApplicationDTO app = registrationService.update(applicationDTO);
        return new ApiResponse<>(UPDATE_SUCCESS, APP_SUCCESS_MESSAGE, app);
    }

    @Override
    public ApiResponse<ApplicationDTO> delete(ApplicationDTO applicationDTO) {
         return null;
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<Boolean> delete(@PathVariable String id) {
        Boolean isDeleted = registrationService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), APP_DELETE_MESSAGE_SUCCESS, isDeleted);
    }


    @Override
    public ApiResponse<PaginationResult<ApplicationDTO>> findAll(String search, Integer page, Integer size, String sortBy) {
        var res = registrationService.findAll(search, page, size, sortBy);
        return new ApiResponse<>(HttpStatus.OK.value(),  APP_RETRIEVE_SUCCESS, res);
    }



    @Override
    public ApiResponse<ApplicationDTO> find(String id) {
        var application = registrationService.find(id);
        return new ApiResponse<>(HttpStatus.OK.value(), APP_RETRIEVE_SUCCESS, application);
    }


}
