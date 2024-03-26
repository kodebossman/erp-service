package za.co.emmtapp.erpservice.security.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import za.co.emmtapp.erpservice.security.model.dto.JwtAuthenticationResponse;
import za.co.emmtapp.erpservice.security.model.dto.SignUpRequest;
import za.co.emmtapp.erpservice.security.model.dto.SigninRequest;

import java.io.IOException;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signIn(SigninRequest request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
