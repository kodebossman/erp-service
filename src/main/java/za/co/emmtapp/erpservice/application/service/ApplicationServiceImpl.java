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
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;

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
            DocumentationDTO documentationDTO = documentService.create(applicationDTO.getDocumentation());
            NextOfKinDTO nextOfKinDTO = nextOfKinService.create(applicationDTO.getNextOfKin());
            EmploymentDetailsDTO employmentDetailsDTO = employmentDetailsService.create(applicationDTO.getEmploymentDetails());
            PreviousQualificationsDTO previousQualificationsDTO = previousQualificationsService.create(applicationDTO.getPreviousQualifications());

            applicationDTO.setPersonalDetails(personalDetailsDTO);
            applicationDTO.setDocumentation(documentationDTO);
            applicationDTO.setNextOfKin(nextOfKinDTO);
            applicationDTO.setEmploymentDetails(employmentDetailsDTO);
            applicationDTO.setPreviousQualifications(previousQualificationsDTO);

        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return applicationDTO;
    }

    @Override
    public ApplicationDTO find(Long id) {

        ApplicationDTO applicationDTO = new ApplicationDTO();

        NextOfKinDTO nextOfKinDTO = nextOfKinService.find(id);
        DocumentationDTO documentationDTO = documentService.find(id);
        EmploymentDetailsDTO employmentDetailsDTO = employmentDetailsService.find(id);
        PreviousQualificationsDTO previousQualificationsDTO = previousQualificationsService.find(id);
        PersonalDetailsDTO personalDetailsDTO = personalDetailsService.find(id);

        applicationDTO.setNextOfKin(nextOfKinDTO);
        applicationDTO.setDocumentation(documentationDTO);
        applicationDTO.setPreviousQualifications(previousQualificationsDTO);
        applicationDTO.setEmploymentDetails(employmentDetailsDTO);
        applicationDTO.setPersonalDetails(personalDetailsDTO);

        return applicationDTO;
    }

    @Override
    public boolean deleteApplication(Long id) {

        personalDetailsService.delete(id);
        documentService.delete(id);
        employmentDetailsService.delete(id);
        nextOfKinService.delete(id);
        previousQualificationsService.delete(id);

        return true;
    }

    @Override
    public ApplicationDTO updateApplication(ApplicationDTO applicationDTO) {

        DocumentationDTO documentationDTO = applicationDTO.getDocumentation();
        EmploymentDetailsDTO employmentDetailsDTO = applicationDTO.getEmploymentDetails();
        NextOfKinDTO nextOfKinDTO = applicationDTO.getNextOfKin();
        PersonalDetailsDTO personalDetailsDTO = applicationDTO.getPersonalDetails();
        PreviousQualificationsDTO previousQualificationsDTO = applicationDTO.getPreviousQualifications();

        if (documentationDTO != null) {
            documentService.update(documentationDTO);
        }

        if (employmentDetailsDTO != null) {
            employmentDetailsService.update(employmentDetailsDTO);
        }

        if (nextOfKinDTO != null) {
            nextOfKinService.update(nextOfKinDTO);
        }

        if (personalDetailsDTO != null) {
            personalDetailsService.update(personalDetailsDTO);
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