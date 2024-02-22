package za.co.emmtapp.erpservice.review.service;

import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.review.model.dto.ApplicationReviewDTO;

public interface ApplicationReviewService {
    ApplicationReviewDTO createApplicationReview(ApplicationReviewDTO applicationReviewDTO);

    ApplicationReviewDTO update(ApplicationReviewDTO applicationReviewDTO);

    ApplicationReviewDTO find(String id);

    PaginationResult<ApplicationReviewDTO> findAll(String search, Integer page, Integer size, String sortBy);

}
