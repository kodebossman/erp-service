package za.co.emmtapp.erpservice.application.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.EmploymentDetails;
import za.co.emmtapp.erpservice.application.model.dto.EmploymentDetailsDTO;
import za.co.emmtapp.erpservice.application.repos.EmploymentDetailsRepository;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class EmploymentDetailsImpl implements EmploymentDetailsService {
    EmploymentDetailsRepository employmentDetailsRepository;

    public EmploymentDetailsImpl(EmploymentDetailsRepository employmentDetailsRepository) {
        this.employmentDetailsRepository = employmentDetailsRepository;
    }
    @Override
    public EmploymentDetailsDTO create(EmploymentDetailsDTO employmentDetailsDTO) {
        EmploymentDetails employmentDetails = new EmploymentDetails();
        BeanUtils.copyProperties(employmentDetailsDTO, employmentDetails);
        employmentDetailsRepository.save(employmentDetails);
        return employmentDetailsDTO;
    }

    @Override
    public EmploymentDetailsDTO find(String applicantId) {
        EmploymentDetailsDTO employmentDetailsDTO = new EmploymentDetailsDTO();
        EmploymentDetails employmentDetails =  employmentDetailsRepository.findByApplicantId(applicantId).orElseThrow(
                () -> new ResourceNotFoundException("application with provided Id not found")
        );
        BeanUtils.copyProperties(employmentDetails, employmentDetailsDTO);
        return employmentDetailsDTO;
    }

    @Override
    public boolean update(EmploymentDetailsDTO employmentDetailsDTO) {
        boolean isUpdated = false;

        if (employmentDetailsDTO != null) {
            EmploymentDetails employmentDetails = employmentDetailsRepository.findByApplicantId(employmentDetailsDTO.getApplicantId()).orElseThrow(
                    () -> new ResourceNotFoundException("application with provided Id not found")
            );

            BeanUtils.copyProperties(employmentDetailsDTO, employmentDetails);

            employmentDetailsRepository.save(employmentDetails);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean delete(String id) {
        employmentDetailsRepository.deleteByApplicantId(id);
        return true;
    }
}
