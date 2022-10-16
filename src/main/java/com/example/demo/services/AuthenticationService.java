package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.entities.Authentication;
import com.example.demo.entities.UserMock;

@Service
public class AuthenticationService {

	@Autowired
	private RestTemplate template;
	
	@PostMapping
	public Authentication getAuthentication() {
		System.out.println("===================================================================================");
	    System.out.println("[INFO] INICIANDO BUSCA POR AUTENTICAÇÃO");
	    System.out.println("===================================================================================");
		UserMock user = new UserMock();
		HttpEntity<UserMock> request = new HttpEntity<>(user, new HttpHeaders());
		
		UriComponents uri = UriComponentsBuilder.newInstance()
	    		.scheme("http")
	    		.host("api.infotravel.com.br")
	    		.path("api/v1/authenticate")
	            .queryParam("username", user.getUsername())
	            .queryParam("password", user.getPassword())
	            .queryParam("client", user.getClient())
	            .queryParam("agency", user.getAgency())
	            .build();

		System.out.println("===================================================================================");
	    System.out.println("[INFO] ENVIANDO REQUISIÇÃO PARA A URL: "+uri.toUriString());
	    System.out.println("===================================================================================");
	    
		return template.postForObject(uri.toUriString(), request, Authentication.class);
	}
}
