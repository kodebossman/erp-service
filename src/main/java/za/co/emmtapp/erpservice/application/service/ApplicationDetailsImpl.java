package za.co.emmtapp.erpservice.application.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.ApplicationDetails;
import za.co.emmtapp.erpservice.application.model.Documentation;
import za.co.emmtapp.erpservice.application.model.dto.ApplicationDetailDTO;
import za.co.emmtapp.erpservice.application.repos.ApplicationDetailsRepository;

import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class ApplicationDetailsImpl implements ApplicationDetailsService {

    private final ApplicationDetailsRepository applicationDetailsRepository;

    @Override
    public ApplicationDetailDTO create(ApplicationDetailDTO applicationDetailsDTO) {
        ApplicationDetails applicationDetails = new ApplicationDetails();
        BeanUtils.copyProperties(applicationDetailsDTO, applicationDetails);
        applicationDetailsRepository.save(applicationDetails);
        return applicationDetailsDTO;
    }

    @Override
    public List<ApplicationDetailDTO> findAllByApplicationId(String applicationId) {
        List<ApplicationDetails> docs = applicationDetailsRepository.findAllByApplicationId(applicationId);
        ApplicationDetailDTO applicationDetailDTO = new ApplicationDetailDTO();
        return docs.stream().map(applicationDetails -> applicationDetailDTO).toList();
    }
}
