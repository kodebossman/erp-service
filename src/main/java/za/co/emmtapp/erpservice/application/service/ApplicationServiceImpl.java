package za.co.emmtapp.erpservice.application.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.*;
import za.co.emmtapp.erpservice.application.model.dto.*;
import za.co.emmtapp.erpservice.application.repos.*;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.exceptions.ApplicationAlreadyExistsException;

import java.util.List;

@Service
@Slf4j
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final DocumentService documentService;
    private  final NextOfKinService nextOfKinService;
    private final PersonalDetailsService personalDetailsService;
    private  final EmploymentDetailsService employmentDetailsService;
    private final PreviousQualificationsService previousQualificationsService;


    public ApplicationServiceImpl(ApplicationRepository applicationRepository,
                                  DocumentService documentService,
                                  NextOfKinService nextOfKinService,
                                  PersonalDetailsService personalDetailsService,
                                  EmploymentDetailsService employmentDetailsService,
                                  PreviousQualificationsService previousQualificationsService) {
        this.applicationRepository = applicationRepository;
        this.documentService = documentService;
        this.nextOfKinService = nextOfKinService;
        this.personalDetailsService = personalDetailsService;
        this.employmentDetailsService = employmentDetailsService;
        this.previousQualificationsService = previousQualificationsService;
    }


    @Override
    public ApplicationDTO createRegistration(ApplicationDTO applicationDTO) {

        try {
            PersonalDetailsDTO personalDetailsDTO = personalDetailsService.create(applicationDTO.getPersonalDetails());
            String idNumber = applicationDTO.getPersonalDetails().getIdNumber();

            applicationDTO.getDocumentation().setOwnerId(idNumber);
            applicationDTO.getNextOfKin().setApplicantId(idNumber);
            applicationDTO.getEmploymentDetails().setApplicantId(idNumber);
            applicationDTO.getPreviousQualifications().setOwnerId(idNumber);


            DocumentationDTO documentationDTO = documentService.create(applicationDTO.getDocumentation());
            NextOfKinDTO nextOfKinDTO = nextOfKinService.create(applicationDTO.getNextOfKin());
            EmploymentDetailsDTO employmentDetailsDTO = employmentDetailsService.create(applicationDTO.getEmploymentDetails());
            PreviousQualificationsDTO previousQualificationsDTO = previousQualificationsService.create(applicationDTO.getPreviousQualifications());

            applicationDTO.setPersonalDetails(personalDetailsDTO);
            applicationDTO.setDocumentation(documentationDTO);
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
        DocumentationDTO documentationDTO = documentService.find(idNumber);
        EmploymentDetailsDTO employmentDetailsDTO = employmentDetailsService.find(idNumber);
        PreviousQualificationsDTO previousQualificationsDTO = previousQualificationsService.find(idNumber);

        applicationDTO.setPersonalDetails(personalDetailsDTO);
        applicationDTO.setNextOfKin(nextOfKinDTO);
        applicationDTO.setDocumentation(documentationDTO);
        applicationDTO.setPreviousQualifications(previousQualificationsDTO);
        applicationDTO.setEmploymentDetails(employmentDetailsDTO);

        return applicationDTO;
    }

    @Override
    public boolean deleteApplication(String idNumber) {

        personalDetailsService.delete(idNumber);
        documentService.delete(idNumber);
        employmentDetailsService.delete(idNumber);
        nextOfKinService.delete(idNumber);
        previousQualificationsService.delete(idNumber);

        return true;
    }

    @Override
    public ApplicationDTO updateApplication(ApplicationDTO applicationDTO) {

        applicationDTO.getDocumentation().setOwnerId(applicationDTO.getPersonalDetails().getIdNumber());
        applicationDTO.getEmploymentDetails().setApplicantId(applicationDTO.getPersonalDetails().getIdNumber());
        applicationDTO.getNextOfKin().setApplicantId(applicationDTO.getPersonalDetails().getIdNumber());
        applicationDTO.getPreviousQualifications().setOwnerId(applicationDTO.getPersonalDetails().getIdNumber());

        DocumentationDTO documentationDTO = applicationDTO.getDocumentation();
        EmploymentDetailsDTO employmentDetailsDTO = applicationDTO.getEmploymentDetails();
        NextOfKinDTO nextOfKinDTO = applicationDTO.getNextOfKin();
        PersonalDetailsDTO personalDetailsDTO = applicationDTO.getPersonalDetails();
        PreviousQualificationsDTO previousQualificationsDTO = applicationDTO.getPreviousQualifications();

        if (personalDetailsDTO != null) {
            personalDetailsService.update(personalDetailsDTO);
        }

        if (documentationDTO != null) {
            documentService.update(documentationDTO);
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
        Page<Application> pageResult = applicationRepository.findAll(pageable);

        List<ApplicationDTO> applicationDTOs = pageResult.getContent().stream()
                .map(ApplicationServiceImpl::toDTO)
                .toList();

        return PaginationResult.pagination(applicationDTOs, pageResult.getTotalElements(), page, size);
    }

    public static ApplicationDTO toDTO(Application application) {
        ApplicationDTO dto = new ApplicationDTO();
        BeanUtils.copyProperties(application, dto);
        return dto;
    }

}