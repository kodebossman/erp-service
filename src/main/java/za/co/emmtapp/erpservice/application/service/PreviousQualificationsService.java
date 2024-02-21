package za.co.emmtapp.erpservice.application.service;

import za.co.emmtapp.erpservice.application.model.dto.NextOfKinDTO;
import za.co.emmtapp.erpservice.application.model.dto.PersonalDetailsDTO;
import za.co.emmtapp.erpservice.application.model.dto.PreviousQualificationsDTO;
import za.co.emmtapp.erpservice.application.repos.PreviousQualificationsRepository;

public interface PreviousQualificationsService {
    public PreviousQualificationsDTO create(PreviousQualificationsDTO previousQualificationsDTO);

    public boolean update(PreviousQualificationsDTO previousQualificationsDTO);
    PreviousQualificationsDTO find(String id);
    boolean delete(String id);

}
