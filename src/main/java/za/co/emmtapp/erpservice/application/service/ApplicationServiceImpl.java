package za.co.emmtapp.erpservice.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.*;
import za.co.emmtapp.erpservice.application.model.dto.ApplicationDTO;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;
import za.co.emmtapp.erpservice.application.model.dto.EmploymentDetailsDTO;
import za.co.emmtapp.erpservice.application.model.dto.NextOfKinDTO;
import za.co.emmtapp.erpservice.application.repos.*;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional

public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    DocumentationRepository documentationRepository;
    @Autowired
    NextOfKinRepository nextOfKinRepository;

    @Autowired
    EmploymentDetailsRepository employmentDetailsRepository;

    @Autowired
    PreviousQualificationsRepository qualificationsRepository;

    @Override
    public ApplicationDTO createRegistration(ApplicationDTO applicationDTO) {

        Application application = new Application();

        BeanUtils.copyProperties(applicationDTO, application);

        Documentation documentation = new Documentation();
        BeanUtils.copyProperties(applicationDTO.getDocumentation(), documentation);

        NextOfKin nextOfKin = new NextOfKin();
        BeanUtils.copyProperties(applicationDTO.getNextOfKin(), nextOfKin);

        EmploymentDetails employmentDetails = new EmploymentDetails();
        BeanUtils.copyProperties(applicationDTO.getEmploymentDetails(), employmentDetails);

        PreviousQualifications previousQualifications = new PreviousQualifications();
        BeanUtils.copyProperties(applicationDTO.getPreviousQualifications(), previousQualifications);


        try {
            documentation = documentationRepository.save(documentation);
        } catch (Exception e) {
            log.info(e.getMessage());
        }


        try {
            application = applicationRepository.save(application);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        try {
            nextOfKin = nextOfKinRepository.save(nextOfKin);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        try {
            employmentDetails = employmentDetailsRepository.save(employmentDetails);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        try {
            previousQualifications = qualificationsRepository.save(previousQualifications);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        BeanUtils.copyProperties(application, applicationDTO);
        BeanUtils.copyProperties(documentation, applicationDTO.getDocumentation());
        BeanUtils.copyProperties(nextOfKin, applicationDTO.getNextOfKin());
        BeanUtils.copyProperties(employmentDetails, applicationDTO.getEmploymentDetails());
        BeanUtils.copyProperties(previousQualifications, applicationDTO.getPreviousQualifications());

        return applicationDTO;
    }

    @Override
    public ApplicationDTO find(Long id) {
        Application application = applicationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("application with provided Id not found")
        );

        ApplicationDTO applicationDTO = new ApplicationDTO();
        BeanUtils.copyProperties(application, applicationDTO);

        return applicationDTO;
    }

    @Override
    public ApplicationDTO deleteApplication(ApplicationDTO applicationDTO) {
        applicationRepository.deleteById(applicationDTO.getId());
        applicationRepository.delete(new Application());
        return applicationDTO;
    }

    @Override
    public ApplicationDTO updateApplication(ApplicationDTO applicationDTO) {

        DocumentationDTO documentationDTO = applicationDTO.getDocumentation();
        EmploymentDetailsDTO employmentDetailsDTO = applicationDTO.getEmploymentDetails();
        NextOfKinDTO nextOfKinDTO = applicationDTO.getNextOfKin();

        if (documentationDTO != null) {
            Documentation documentation = documentationRepository.findByOwnerId(documentationDTO.getOwnerId()).orElseThrow(
                    () -> new ResourceNotFoundException("Document with given ID not found")
            );
            BeanUtils.copyProperties(documentationDTO, documentation);
            documentation = documentationRepository.save(documentation);
        }

        if (employmentDetailsDTO != null) {
            EmploymentDetails employmentDetails = employmentDetailsRepository.findByApplicantId(employmentDetailsDTO.getApplicantId()).orElseThrow(
                    () -> new ResourceNotFoundException("Record with given applicantID not found")
            );
            BeanUtils.copyProperties(employmentDetailsDTO, employmentDetails);
            employmentDetails = employmentDetailsRepository.save(employmentDetails);
        }

        if (nextOfKinDTO != null) {
            NextOfKin nextOfKin = nextOfKinRepository.findByApplicantId(nextOfKinDTO.getApplicantId()).orElseThrow(
                    () -> new ResourceNotFoundException("Record with given applicantID not found")
            );
            BeanUtils.copyProperties(nextOfKinDTO, nextOfKin);
             nextOfKinRepository.save(nextOfKin);
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