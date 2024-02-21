package za.co.emmtapp.erpservice.review.service;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.PersonalDetails;
import za.co.emmtapp.erpservice.application.repos.PersonalDetailsRepository;
import za.co.emmtapp.erpservice.exceptions.ApplicationNotFoundException;
import za.co.emmtapp.erpservice.review.model.ApplicationReview;
import za.co.emmtapp.erpservice.review.model.ApplicationReviewStatus;
import za.co.emmtapp.erpservice.review.model.dto.ApplicationReviewDTO;
import za.co.emmtapp.erpservice.review.repository.ApplicationReviewRepository;

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
}
