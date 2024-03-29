package za.co.emmtapp.erpservice.application.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.PreviousQualifications;
import za.co.emmtapp.erpservice.application.model.dto.PreviousQualificationsDTO;
import za.co.emmtapp.erpservice.application.repos.PreviousQualificationsRepository;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class PreviousQualificationsServiceImpl implements  PreviousQualificationsService {
    private final PreviousQualificationsRepository previousQualificationsRepository;

    public PreviousQualificationsServiceImpl(PreviousQualificationsRepository previousQualificationsRepository) {
        this.previousQualificationsRepository = previousQualificationsRepository;
    }

    @Override
    public PreviousQualificationsDTO create(PreviousQualificationsDTO previousQualificationsDTO) {
        PreviousQualifications previousQualifications = new PreviousQualifications();
        BeanUtils.copyProperties(previousQualificationsDTO, previousQualifications);
        previousQualificationsRepository.save(previousQualifications);
        return previousQualificationsDTO;
    }

    @Override
    public boolean update(PreviousQualificationsDTO previousQualificationsDTO) {
        boolean isUpdated = false;

        if (previousQualificationsDTO != null) {
            PreviousQualifications previousQualifications = previousQualificationsRepository
                    .findByOwnerId(previousQualificationsDTO.getOwnerId())
                    .orElseThrow(
                    () -> new ResourceNotFoundException("application with provided Id not found")
            );

            BeanUtils.copyProperties(previousQualificationsDTO, previousQualifications);

            previousQualificationsRepository.save(previousQualifications);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public PreviousQualificationsDTO find(String id) {
        PreviousQualificationsDTO previousQualificationsDTO = new PreviousQualificationsDTO();
        PreviousQualifications previousQualifications =  previousQualificationsRepository.findByOwnerId(id).orElseThrow(
                () -> new ResourceNotFoundException("application with provided Id not found")
        );
        BeanUtils.copyProperties(previousQualifications, previousQualificationsDTO);
        return previousQualificationsDTO;
    }

    @Override
    public boolean delete(String id) {
        previousQualificationsRepository.deleteByOwnerId(id);
        return true;
    }
}
