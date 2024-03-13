package za.co.emmtapp.erpservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.emmtapp.erpservice.security.model.JwtAuthenticationResponse;
import za.co.emmtapp.erpservice.security.model.SigninRequest;
import za.co.emmtapp.erpservice.security.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationAPI {
    private final AuthenticationService authenticationService;
//    @PostMapping("/signup")
//    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
//        return ResponseEntity.ok(authenticationService.signup(request));
//    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
