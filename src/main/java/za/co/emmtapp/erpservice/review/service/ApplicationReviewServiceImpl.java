package za.co.emmtapp.erpservice.review.service;

import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.review.model.dto.ApplicationReviewDTO;

@Service
public class ApplicationReviewServiceImpl implements ApplicationReviewService{
    @Override
    public ApplicationReviewDTO createApplicationReview(ApplicationReviewDTO applicationReviewDTO) {

        if (applicationReviewDTO.getStatus().equals("Accepted")){

            //send Applicant email notification With Details that its accepted

        }else if( applicationReviewDTO.getReviewStatus().equals(" INCOMPLETE")){

            //send Notification application is incomplete And Add Description of Missing info
        }else if ( "rejected".equals("status")){
            //send Notification with rejection and reason for rejection

        }

        //SAve this infomation in DB

        return null;
    }
}
