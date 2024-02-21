package za.co.emmtapp.erpservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.emmtapp.erpservice.common.ApiResponse;
import za.co.emmtapp.erpservice.common.CrudApi;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.review.model.ApplicationReview;
import za.co.emmtapp.erpservice.review.model.dto.ApplicationReviewDTO;
import za.co.emmtapp.erpservice.review.service.ApplicationReviewService;

import static za.co.emmtapp.erpservice.common.ApiConstants.APP_SUCCESS_MESSAGE;

@RestController
@RequestMapping("/review")
@Slf4j
public class ApplicationReviewAPI implements CrudApi<ApplicationReviewDTO> {

    private final ApplicationReviewService applicationReviewService;


    public ApplicationReviewAPI(ApplicationReviewService applicationReviewService) {
        this.applicationReviewService = applicationReviewService;
    }

    @Override
    public ApiResponse<ApplicationReviewDTO> create(ApplicationReviewDTO applicationReviewDTO) {
        ApplicationReviewDTO reviewedApplication = applicationReviewService.createApplicationReview(applicationReviewDTO);
        return new ApiResponse<>(HttpStatus.CREATED.value(), APP_SUCCESS_MESSAGE, reviewedApplication);
    }

    @Override
    public ApiResponse<ApplicationReviewDTO> update(ApplicationReviewDTO applicationReviewDTO) {
        return null;
    }

    @Override
    public ApiResponse<ApplicationReviewDTO> delete(ApplicationReviewDTO applicationReviewDTO) {
        return null;
    }

    @Override
    public ApiResponse<PaginationResult<ApplicationReviewDTO>> findAll(String search, Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public ApiResponse<ApplicationReviewDTO> find(Long id) {
        return null;
    }
}
