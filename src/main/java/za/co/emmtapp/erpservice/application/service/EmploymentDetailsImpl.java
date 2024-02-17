package za.co.emmtapp.erpservice.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.EmploymentDetails;
import za.co.emmtapp.erpservice.application.repos.EmploymentDetailsRepository;

@Service
public class EmploymentDetailsImpl implements EmploymentDetailsService{
    @Autowired
    EmploymentDetailsRepository employmentDetailsRepository;
    @Override
    public EmploymentDetails createEmploymentDetails(EmploymentDetails employmentDetails) {
        return employmentDetailsRepository.save(employmentDetails);
    }
}
