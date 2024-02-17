package za.co.emmtapp.erpservice.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.application.model.NextOfKin;
import za.co.emmtapp.erpservice.application.repos.NextOfKinRepository;

@Service
public class NextOfKinServiceImpl implements NextOfKinService {

    @Autowired
    NextOfKinRepository nextOfKinRepository;
    @Override
    public NextOfKin createNextOfKeen(NextOfKin nextOfKin) {
        return nextOfKinRepository.save(nextOfKin);
    }
}
