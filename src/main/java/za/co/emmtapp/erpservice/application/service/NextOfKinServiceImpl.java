package za.co.emmtapp.erpservice.application.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.NextOfKin;
import za.co.emmtapp.erpservice.application.model.dto.NextOfKinDTO;
import za.co.emmtapp.erpservice.application.repos.NextOfKinRepository;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class NextOfKinServiceImpl implements NextOfKinService {
    NextOfKinRepository nextOfKinRepository;

    public NextOfKinServiceImpl(NextOfKinRepository nextOfKinRepository) {
        this.nextOfKinRepository = nextOfKinRepository;
    }

    @Override
    public NextOfKinDTO create(NextOfKinDTO nextOfKinDTO) {
        NextOfKin nextOfKin = new NextOfKin();
        BeanUtils.copyProperties(nextOfKinDTO, nextOfKin);
        nextOfKinRepository.save(nextOfKin);
        return nextOfKinDTO;
    }

    @Override
    public boolean update(NextOfKinDTO nextOfKinDTO) {
        boolean isUpdated = false;

        if (nextOfKinDTO != null) {
            NextOfKin nextOfKin = nextOfKinRepository.findByApplicantId(nextOfKinDTO.getApplicantId()).orElseThrow(
                    () -> new ResourceNotFoundException("application with provided Id not found")
            );

            BeanUtils.copyProperties(nextOfKinDTO, nextOfKin);

            nextOfKinRepository.save(nextOfKin);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public NextOfKinDTO find(String applicantId) {
        NextOfKinDTO nextOfKinDTO = new NextOfKinDTO();
        NextOfKin nextOfKin =  nextOfKinRepository.findByApplicantId(applicantId).orElseThrow(
                () -> new ResourceNotFoundException("Application with provided Id not found")
        );
        BeanUtils.copyProperties(nextOfKin, nextOfKinDTO);
        return nextOfKinDTO;
    }

    @Override
    public boolean delete(String id) {
        nextOfKinRepository.deleteByApplicantId(id);
        return true;
    }

}
