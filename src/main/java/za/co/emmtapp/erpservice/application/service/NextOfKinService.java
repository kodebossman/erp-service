package za.co.emmtapp.erpservice.application.service;

import za.co.emmtapp.erpservice.application.model.NextOfKin;
import za.co.emmtapp.erpservice.application.model.dto.DocumentationDTO;
import za.co.emmtapp.erpservice.application.model.dto.NextOfKinDTO;

public interface NextOfKinService {
    public NextOfKinDTO create(NextOfKinDTO nextOfKinDTO);
    public boolean update(NextOfKinDTO nextOfKinDTO);
    NextOfKinDTO find(Long id);

    public boolean delete(Long id);
}
