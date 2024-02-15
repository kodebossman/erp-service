package za.co.emmtapp.erpservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.emmtapp.erpservice.common.ApiResponse;
import za.co.emmtapp.erpservice.common.CrudApi;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;
import za.co.emmtapp.erpservice.application.service.RegistrationService;
import za.co.emmtapp.erpservice.utils.ErpUtils;

import static za.co.emmtapp.erpservice.common.ApiConstants.APP_SUCCESS_MESSAGE;

@RestController
@RequestMapping("/application")
@Slf4j
@RequiredArgsConstructor
public class RegistrationAPI implements CrudApi<ApplicationDTO> {

    private final RegistrationService registrationService;

    @PostMapping("/apply")
    @Override
    public ApiResponse<ApplicationDTO> create(@RequestBody ApplicationDTO applicationDTO) {

        log.info("New Application {} ", ErpUtils.logData(applicationDTO));

        ApplicationDTO applicationDTO1 = registrationService.createRegistration(applicationDTO);

        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, applicationDTO1);


    }

    @Override
    public ApiResponse<ApplicationDTO> update(ApplicationDTO applicationDTO) {
        return null;
    }

    @Override
    public ApiResponse<ApplicationDTO> delete(ApplicationDTO applicationDTO) {
        return null;
    }

    @Override
    public ApiResponse<PaginationResult<ApplicationDTO>> findAll(String search, Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public ApiResponse<ApplicationDTO> find(Long id) {
        return null;
    }
}
