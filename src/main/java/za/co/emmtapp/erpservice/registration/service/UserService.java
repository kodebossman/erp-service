package za.co.emmtapp.erpservice.registration.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.registration.model.dto.UserDTO;

@Service
public interface UserService {
    UserDTO find(Long id);

    boolean update(UserDTO userDTO);

    boolean delete(Long id);

    PaginationResult<UserDTO> findAll(String search, Integer page, Integer size, String sortBy);

    UserDetailsService userDetailsService();
}
