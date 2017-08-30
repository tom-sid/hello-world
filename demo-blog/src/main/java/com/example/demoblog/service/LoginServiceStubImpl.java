package com.example.demoblog.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceStubImpl implements LoginService {

	@Override
	public boolean authenticate(String username, String password) {
		// Provide a sample password check: username == password
		return Objects.equals(username, password);
	}

}
