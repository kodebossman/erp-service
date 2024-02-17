package za.co.emmtapp.erpservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.emmtapp.erpservice.application.model.Application;
import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;
import za.co.emmtapp.erpservice.common.ApiResponse;
import za.co.emmtapp.erpservice.common.CrudApi;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.application.service.ApplicationService;

import static za.co.emmtapp.erpservice.common.ApiConstants.APP_SUCCESS_MESSAGE;

@RestController
@RequestMapping("/application")
@Slf4j
@RequiredArgsConstructor
public class ApplicationAPI implements CrudApi<ApplicationDTO> {

    @Autowired
    private final ApplicationService registrationService;


    @Override
    public ApiResponse<ApplicationDTO> create(ApplicationDTO applicationDTO) {
        ApplicationDTO app = registrationService.createRegistration(applicationDTO);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, app);
    }

    @Override
    public ApiResponse<ApplicationDTO> update(ApplicationDTO applicationDTO) {
        ApplicationDTO app = registrationService.updateApplication(applicationDTO);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, app);
    }

    @Override
    public ApiResponse<ApplicationDTO> delete(ApplicationDTO applicationDTO) {
         ApplicationDTO appDTO = registrationService.deleteApplication(applicationDTO);
         return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, appDTO);
    }

    @Override
    public ApiResponse<PaginationResult<ApplicationDTO>> findAll(String search, Integer page, Integer size, String sortBy) {
        var res = registrationService.findAll(search, page, size, sortBy);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, res);
    }

//    @GetMapping("getAll")
//    public ApiResponse<PaginationResult<Application>> findAllApps(@RequestParam(defaultValue = "") String search,
//                                                                  @RequestParam(defaultValue = "1") Integer page,
//                                                                  @RequestParam(defaultValue = "10") Integer size,
//                                                                  @RequestParam(defaultValue = "id") String sortBy) {
//
//        var res = registrationService.findAll(search, page, size, sortBy);
//        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, res);
//    }


    @Override
    public ApiResponse<ApplicationDTO> find(Long id) {
        var application = registrationService.find(id);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, application);
    }



}
