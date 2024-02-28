package za.co.emmtapp.erpservice.application.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.*;
import za.co.emmtapp.erpservice.application.model.dto.*;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.exceptions.ApplicationAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    private final DocumentService documentService;
    private  final NextOfKinService nextOfKinService;
    private final PersonalDetailsService personalDetailsService;
    private  final EmploymentDetailsService employmentDetailsService;
    private final PreviousQualificationsService previousQualificationsService;


    @Override
    public ApplicationDTO createRegistration(ApplicationDTO applicationDTO) {

        try {
            PersonalDetailsDTO personalDetailsDTO = personalDetailsService.create(applicationDTO.getPersonalDetails());
            String idNumber = applicationDTO.getPersonalDetails().getIdNumber();

            applicationDTO.getDocumentation().forEach(document -> document.setOwnerId(idNumber));
            applicationDTO.getNextOfKin().setApplicantId(idNumber);
            applicationDTO.getEmploymentDetails().setApplicantId(idNumber);
            applicationDTO.getPreviousQualifications().setOwnerId(idNumber);


            List<DocumentationDTO> documentations = new ArrayList<>();

            for (var documentation : applicationDTO.getDocumentation()) {
                DocumentationDTO documentationDTO = documentService.create(documentation);
                documentations.add(documentationDTO);
            }
            NextOfKinDTO nextOfKinDTO = nextOfKinService.create(applicationDTO.getNextOfKin());
            EmploymentDetailsDTO employmentDetailsDTO = employmentDetailsService.create(applicationDTO.getEmploymentDetails());
            PreviousQualificationsDTO previousQualificationsDTO = previousQualificationsService.create(applicationDTO.getPreviousQualifications());

            applicationDTO.setPersonalDetails(personalDetailsDTO);
            applicationDTO.setDocumentation(documentations);
            applicationDTO.setNextOfKin(nextOfKinDTO);
            applicationDTO.setEmploymentDetails(employmentDetailsDTO);
            applicationDTO.setPreviousQualifications(previousQualificationsDTO);

        } catch (ApplicationAlreadyExistsException e) {
            log.info(e.getMessage());
            throw e;
        }
        return applicationDTO;
    }

    @Override
    public ApplicationDTO find(String idNumber) {

        ApplicationDTO applicationDTO = new ApplicationDTO();

        PersonalDetailsDTO personalDetailsDTO = personalDetailsService.find(idNumber);
        NextOfKinDTO nextOfKinDTO = nextOfKinService.find(idNumber);
        List<DocumentationDTO> documentationDTOs = documentService.findAllByOwnerId(idNumber);
        EmploymentDetailsDTO employmentDetailsDTO = employmentDetailsService.find(idNumber);
        PreviousQualificationsDTO previousQualificationsDTO = previousQualificationsService.find(idNumber);

        applicationDTO.setPersonalDetails(personalDetailsDTO);
        applicationDTO.setNextOfKin(nextOfKinDTO);
        applicationDTO.setDocumentation(documentationDTOs);
        applicationDTO.setPreviousQualifications(previousQualificationsDTO);
        applicationDTO.setEmploymentDetails(employmentDetailsDTO);

        return applicationDTO;
    }

    @Override
    public boolean delete(String idNumber) {
        boolean isDeleted = false;

        personalDetailsService.delete(idNumber);
        documentService.delete(idNumber);
        employmentDetailsService.delete(idNumber);
        nextOfKinService.delete(idNumber);
        previousQualificationsService.delete(idNumber);

        isDeleted = true;

        return isDeleted;
    }

    @Override
    public ApplicationDTO update(ApplicationDTO applicationDTO) {

        applicationDTO.getDocumentation().forEach(doc -> doc.setOwnerId(applicationDTO.getPersonalDetails().getIdNumber()));
        applicationDTO.getEmploymentDetails().setApplicantId(applicationDTO.getPersonalDetails().getIdNumber());
        applicationDTO.getNextOfKin().setApplicantId(applicationDTO.getPersonalDetails().getIdNumber());
        applicationDTO.getPreviousQualifications().setOwnerId(applicationDTO.getPersonalDetails().getIdNumber());

        List<DocumentationDTO> documentationDTO = applicationDTO.getDocumentation();
        EmploymentDetailsDTO employmentDetailsDTO = applicationDTO.getEmploymentDetails();
        NextOfKinDTO nextOfKinDTO = applicationDTO.getNextOfKin();
        PersonalDetailsDTO personalDetailsDTO = applicationDTO.getPersonalDetails();
        PreviousQualificationsDTO previousQualificationsDTO = applicationDTO.getPreviousQualifications();

        if (personalDetailsDTO != null) {
            personalDetailsService.update(personalDetailsDTO);
        }

        if (documentationDTO != null) {
            documentationDTO.forEach(documentService::update);

        }

        if (employmentDetailsDTO != null) {
            employmentDetailsService.update(employmentDetailsDTO);
        }

        if (nextOfKinDTO != null) {
            nextOfKinService.update(nextOfKinDTO);
        }

        if (previousQualificationsDTO != null) {
            previousQualificationsService.update(previousQualificationsDTO);
        }

        return applicationDTO;
    }

    @Override
    public PaginationResult<ApplicationDTO> findAll(String search, Integer page, Integer size, String sortBy) {
        var pageable = PageRequest.of(page - 1, size, Sort.by(sortBy));
        Page<PersonalDetails> pageResult = personalDetailsService.findAll(pageable);

        List<ApplicationDTO> applicationDTOs = pageResult.getContent().stream()
                .map(this::convertToApplicationDto)
                .toList();

        log.info(applicationDTOs.toString());

        return PaginationResult.pagination(applicationDTOs, pageResult.getTotalElements(), page, size);
    }

    private ApplicationDTO convertToApplicationDto(PersonalDetails personalDetails) {
        ApplicationDTO applicationDTO = new ApplicationDTO();

        PersonalDetailsDTO personalDetailsDTO = new PersonalDetailsDTO();
        List<DocumentationDTO> documentationDTO = documentService.findAllByOwnerId(personalDetails.getIdNumber());
        NextOfKinDTO nextOfKinDTO = nextOfKinService.find(personalDetails.getIdNumber());
        PreviousQualificationsDTO previousQualificationsDTO = previousQualificationsService.find(personalDetails.getIdNumber());
        EmploymentDetailsDTO employmentDetailsDTO = employmentDetailsService.find(personalDetails.getIdNumber());

        BeanUtils.copyProperties(personalDetails, personalDetailsDTO);
        applicationDTO.setPersonalDetails(personalDetailsDTO);
        applicationDTO.setEmploymentDetails(employmentDetailsDTO);
        applicationDTO.setDocumentation(documentationDTO);
        applicationDTO.setNextOfKin(nextOfKinDTO);
        applicationDTO.setPreviousQualifications(previousQualificationsDTO);
        return applicationDTO;
    }
}