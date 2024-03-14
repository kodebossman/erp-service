package za.co.emmtapp.erpservice.security.service;

import za.co.emmtapp.erpservice.security.model.JwtAuthenticationResponse;
import za.co.emmtapp.erpservice.security.model.SignUpRequest;
import za.co.emmtapp.erpservice.security.model.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signIn(SigninRequest request);
}
