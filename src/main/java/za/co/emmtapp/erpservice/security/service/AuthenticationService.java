package za.co.emmtapp.erpservice.security.service;

import za.co.emmtapp.erpservice.security.model.JwtAuthenticationResponse;
import za.co.emmtapp.erpservice.security.model.SigninRequest;

public interface AuthenticationService {
//    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
