package za.co.emmtapp.erpservice.application.service;

import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.NextOfKin;
import za.co.emmtapp.erpservice.application.repos.NextOfKinRepository;

@Service
public class NextOfKinServiceImpl implements NextOfKinService {
    NextOfKinRepository nextOfKinRepository;

    public NextOfKinServiceImpl(NextOfKinRepository nextOfKinRepository) {
        this.nextOfKinRepository = nextOfKinRepository;
    }

    @Override
    public NextOfKin createNextOfKeen(NextOfKin nextOfKin) {
        return nextOfKinRepository.save(nextOfKin);
    }
}
