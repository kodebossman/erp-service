package za.co.emmtapp.erpservice.review.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.review.model.ApplicationReview;
import za.co.emmtapp.erpservice.review.model.dto.ApplicationReviewDTO;
import za.co.emmtapp.erpservice.review.repository.ApplicationReviewRepository;

@Service
@AllArgsConstructor
public class ApplicationReviewServiceImpl implements ApplicationReviewService {

    private final ApplicationReviewRepository applicationReviewRepository;
    @Override
    public ApplicationReviewDTO createApplicationReview(ApplicationReviewDTO applicationReviewDTO) {

        if (applicationReviewDTO.getStatus().equals("Accepted")){

            //send Applicant email notification With Details that its accepted

        }else if( applicationReviewDTO.getReviewStatus().equals(" INCOMPLETE")){

            //send Notification application is incomplete And Add Description of Missing info
        }else if ( "rejected".equals("status")){
            //send Notification with rejection and reason for rejection

        }

        ApplicationReview applicationReview = new ApplicationReview();
        BeanUtils.copyProperties(applicationReviewDTO, applicationReview);

        // Save this information in DB

        applicationReviewRepository.save(applicationReview);

        BeanUtils.copyProperties(applicationReview, applicationReviewDTO);

        return applicationReviewDTO;
    }
}
