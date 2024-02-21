package za.co.emmtapp.erpservice.application.service;

import za.co.emmtapp.erpservice.application.model.dto.PreviousQualificationsDTO;

public interface PreviousQualificationsService {
    PreviousQualificationsDTO create(PreviousQualificationsDTO previousQualificationsDTO);
    boolean update(PreviousQualificationsDTO previousQualificationsDTO);
    PreviousQualificationsDTO find(String id);
    boolean delete(String id);
}
