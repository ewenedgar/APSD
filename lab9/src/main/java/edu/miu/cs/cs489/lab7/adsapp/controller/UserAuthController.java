package edu.miu.cs.cs489.lab7.adsapp.controller;

import edu.miu.cs.cs489.lab7.adsapp.dto.user.UserAuthRequest;
import edu.miu.cs.cs489.lab7.adsapp.dto.user.UserAuthResponse;
import edu.miu.cs.cs489.lab7.adsapp.service.UserService;
import edu.miu.cs.cs489.lab7.adsapp.service.util.JWTMgmtUtilityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(value = {"/ads/api/v1/public/auth"})
public class UserAuthController {
@Autowired
    private JWTMgmtUtilityService jwtMgmtUtilityService;
@Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
/*
    public UserAuthController(JWTMgmtUtilityService jwtMgmtUtilityService,
                              AuthenticationManager authenticationManager,
                              UserService userService) {
        this.jwtMgmtUtilityService = jwtMgmtUtilityService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

 */

    @PostMapping(value = {"/login"})
    public ResponseEntity<UserAuthResponse> authenticateUser(@Valid @RequestBody UserAuthRequest userAuthRequest) throws Exception {
        UserAuthResponse userAuthResponse = null;
        try {
            var username = userAuthRequest.username();
            var password = userAuthRequest.password();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,
                            password)
            );
            var jwtToken = jwtMgmtUtilityService.generateToken(username);
            var user = userService.getUserByUsername(username);
            if(user != null) {
                userAuthResponse = new UserAuthResponse(jwtToken, user.getFirstName(), user.getLastName());
            }
        } catch (Exception ex) {
            System.out.println("UserAuthException is: " + ex);
            throw ex;
        }
        return ResponseEntity.ok(userAuthResponse);
    }

}
