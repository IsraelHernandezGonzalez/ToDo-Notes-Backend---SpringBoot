package com.example.todonotes.services.infraestructure.concrete;

import java.util.Objects;

import com.example.todonotes.infraestructure.utils.JwtTokenUtility;
import com.example.todonotes.models.response.LoginResponseModel;
import com.example.todonotes.services.infraestructure.abstraction.IAuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Implementation of the logic for the control of user authentication exposed by IAuthenticationService.
 */
@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
    
	@Autowired
	private JwtTokenUtility jwtTokenUtility;

    @Override
    public LoginResponseModel login(String userName, String password) throws Exception {
        
        Objects.requireNonNull(userName);
		Objects.requireNonNull(password);

		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));

			// TODO : modify the catch section ?

		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        String jwtToken = jwtTokenUtility.generateToken(userDetails);

        return new LoginResponseModel(jwtToken);
    }
    
}
