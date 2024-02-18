package za.co.emmtapp.erpservice.application.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.Documentation;
import za.co.emmtapp.erpservice.application.model.NextOfKin;
import za.co.emmtapp.erpservice.application.model.PersonalDetails;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;
import za.co.emmtapp.erpservice.application.model.dto.NextOfKinDTO;
import za.co.emmtapp.erpservice.application.model.dto.PersonalDetailsDTO;
import za.co.emmtapp.erpservice.application.repos.PersonalDetailsRepository;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;

@Service
public class PersonalDetailsServiceImpl implements  PersonalDetailsService {

    private final PersonalDetailsRepository personalDetailsRepository;

    public PersonalDetailsServiceImpl(PersonalDetailsRepository personalDetailsRepository) {
        this.personalDetailsRepository = personalDetailsRepository;
    }

    @Override
    public PersonalDetailsDTO create(PersonalDetailsDTO personalDetailsDTO) {
        PersonalDetails personalDetails = new PersonalDetails();
        BeanUtils.copyProperties(personalDetailsDTO, personalDetails);
        personalDetailsRepository.save(personalDetails);
        return personalDetailsDTO;
    }

    @Override
    public boolean update(PersonalDetailsDTO personalDetailsDTO) {
        boolean isUpdated = false;

        if (personalDetailsDTO != null) {
            PersonalDetails personalDetails = personalDetailsRepository.findById(personalDetailsDTO.getOwnerId()).orElseThrow(
                    () -> new ResourceNotFoundException("application with provided Id not found")
            );

            BeanUtils.copyProperties(personalDetailsDTO, personalDetails);

            personalDetailsRepository.save(personalDetails);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public PersonalDetailsDTO find(Long id) {
        PersonalDetailsDTO personalDetailsDTO = new PersonalDetailsDTO();
        PersonalDetails personalDetails =  personalDetailsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("application with provided Id not found")
        );
        BeanUtils.copyProperties(personalDetails, personalDetailsDTO);
        return personalDetailsDTO;
    }

    @Override
    public boolean delete(Long id) {
        personalDetailsRepository.deleteById(id);
        return true;
    }
}
