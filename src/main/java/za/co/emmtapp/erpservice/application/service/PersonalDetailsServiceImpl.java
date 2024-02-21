package za.co.emmtapp.erpservice.application.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.PersonalDetails;
import za.co.emmtapp.erpservice.application.model.dto.PersonalDetailsDTO;
import za.co.emmtapp.erpservice.application.repos.PersonalDetailsRepository;
import za.co.emmtapp.erpservice.exceptions.ApplicationAlreadyExistsException;
import za.co.emmtapp.erpservice.exceptions.ApplicationNotFoundException;

import java.util.Optional;

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
        Optional<PersonalDetails> optionalPersonalDetails = personalDetailsRepository.findByIdNumber(personalDetailsDTO.getIdNumber());
        if (optionalPersonalDetails.isPresent()) {
            throw new ApplicationAlreadyExistsException("Application already registered with given id " + personalDetailsDTO.getIdNumber());
        }
        personalDetailsRepository.save(personalDetails);
        return personalDetailsDTO;
    }

    @Override
    public boolean update(PersonalDetailsDTO personalDetailsDTO) {
        boolean isUpdated = false;

        if (personalDetailsDTO != null) {
            PersonalDetails personalDetails = personalDetailsRepository.findByIdNumber(personalDetailsDTO.getIdNumber()).orElseThrow(
                    () -> new ApplicationNotFoundException("Application with provided Id " + personalDetailsDTO.getIdNumber()  + " not found " )
            );

            BeanUtils.copyProperties(personalDetailsDTO, personalDetails);

            personalDetailsRepository.save(personalDetails);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public PersonalDetailsDTO find(String idNumber) {
        PersonalDetailsDTO personalDetailsDTO = new PersonalDetailsDTO();
        PersonalDetails personalDetails =  personalDetailsRepository.findByIdNumber(idNumber).orElseThrow(
                () -> new ApplicationNotFoundException("Application with provided Id not found " + idNumber)
        );
        BeanUtils.copyProperties(personalDetails, personalDetailsDTO);
        return personalDetailsDTO;
    }

    @Override
    public boolean delete(String id) {
        personalDetailsRepository.deleteByIdNumber(id);
        return true;
    }
}
