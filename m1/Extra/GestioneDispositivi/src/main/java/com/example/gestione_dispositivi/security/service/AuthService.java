package com.example.gestione_dispositivi.security.service;

import com.example.gestione_dispositivi.security.payload.LoginDto;
import com.example.gestione_dispositivi.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
