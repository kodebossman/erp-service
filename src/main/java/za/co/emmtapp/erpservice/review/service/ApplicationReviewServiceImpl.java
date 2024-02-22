package za.co.emmtapp.erpservice.review.service;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.Application;
import za.co.emmtapp.erpservice.application.model.Documentation;
import za.co.emmtapp.erpservice.application.model.PersonalDetails;
import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;
import za.co.emmtapp.erpservice.application.repos.PersonalDetailsRepository;
import za.co.emmtapp.erpservice.application.service.ApplicationServiceImpl;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.exceptions.ApplicationNotFoundException;
import za.co.emmtapp.erpservice.review.model.ApplicationReview;
import za.co.emmtapp.erpservice.review.model.ApplicationReviewStatus;
import za.co.emmtapp.erpservice.review.model.dto.ApplicationReviewDTO;
import za.co.emmtapp.erpservice.review.repository.ApplicationReviewRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ApplicationReviewServiceImpl implements ApplicationReviewService {

    private final ApplicationReviewRepository applicationReviewRepository;

    private final PersonalDetailsRepository personalDetailsRepository;

    private final  EmailService emailService;
    @Override
    public ApplicationReviewDTO createApplicationReview(ApplicationReviewDTO applicationReviewDTO) {

        ApplicationReviewStatus status = ApplicationReviewStatus.valueOf(applicationReviewDTO.getReviewStatus());

        // Find Personal email address associated with the applicationId

        PersonalDetails  personalDetails = personalDetailsRepository
                .findByIdNumber(applicationReviewDTO.getApplicationId()).orElseThrow(
                        () -> new ApplicationNotFoundException("No valid email address for the given applicant")
                );


        String emailAddress = personalDetails.getEmailAddress();

        if (status.equals(ApplicationReviewStatus.ACCEPTED)){
            try {
                emailService.sendProfileConfirmationMail(applicationReviewDTO, emailAddress, "ACCEPTED");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

        } else if (status.equals(ApplicationReviewStatus.REJECTED)) {
            try {
                emailService.sendProfileConfirmationMail(applicationReviewDTO, emailAddress, "REJECTED");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

        } else if (status.equals(ApplicationReviewStatus.PENDING)) {
            try {
                emailService.sendProfileConfirmationMail(applicationReviewDTO, emailAddress, "PENDING");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        } else {
            log.info("No action to take");
        }
        ApplicationReview applicationReview = new ApplicationReview();
        BeanUtils.copyProperties(applicationReviewDTO, applicationReview);


        // Save this information in DB
        applicationReviewRepository.save(applicationReview);

        BeanUtils.copyProperties(applicationReview, applicationReviewDTO);
        return applicationReviewDTO;
    }

    @Override
    public ApplicationReviewDTO update(ApplicationReviewDTO applicationReviewDTO) {
        if (applicationReviewDTO != null) {
            ApplicationReview applicationReview = applicationReviewRepository.findByApplicationId(applicationReviewDTO.getApplicationId()).orElseThrow(
                    () -> new ApplicationNotFoundException("application with provided " + applicationReviewDTO.getApplicationId() + "  not found")
            );

            BeanUtils.copyProperties(applicationReviewDTO, applicationReview);

            ApplicationReview savedApplicationReview = applicationReviewRepository.save(applicationReview);

            BeanUtils.copyProperties(applicationReviewDTO, savedApplicationReview);
        }
        return applicationReviewDTO;
    }

    @Override
    public ApplicationReviewDTO find(String id) {
        ApplicationReviewDTO applicationReviewDTO = new ApplicationReviewDTO();
        ApplicationReview applicationReview =  applicationReviewRepository.findByApplicationId(id).orElseThrow(
                () -> new ApplicationNotFoundException("application with provided " + applicationReviewDTO.getApplicationId() + "  not found")
        );
        BeanUtils.copyProperties(applicationReview, applicationReviewDTO);
        return applicationReviewDTO;
    }

    @Override
    public PaginationResult<ApplicationReviewDTO> findAll(String search, Integer page, Integer size, String sortBy) {
        var pageable = PageRequest.of(page - 1, size, Sort.by(sortBy));
        Page<ApplicationReview> pageResult = applicationReviewRepository.findAll(pageable);

        List<ApplicationReviewDTO> applicationDTOs = pageResult.getContent().stream()
                .map(ApplicationReviewServiceImpl::toDTO)
                .toList();

        return PaginationResult.pagination(applicationDTOs, pageResult.getTotalElements(), page, size);
    }

    public static ApplicationReviewDTO toDTO(ApplicationReview applicationReview) {
        ApplicationReviewDTO dto = new ApplicationReviewDTO();
        BeanUtils.copyProperties(applicationReview, dto);
        return dto;
    }
}
