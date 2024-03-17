package za.co.emmtapp.erpservice.security.service;

import za.co.emmtapp.erpservice.security.model.dto.JwtAuthenticationResponse;
import za.co.emmtapp.erpservice.security.model.dto.SignUpRequest;
import za.co.emmtapp.erpservice.security.model.dto.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signIn(SigninRequest request);
}
