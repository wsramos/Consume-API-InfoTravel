package com.example.demo.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.entities.Authentication;
import com.example.demo.entities.SearchHotel;

@Service
public class SearchService {

	@Autowired
	private RestTemplate template;

	@GetMapping
	public SearchHotel getHoteis(String destination, 
								String start, 
								String end,
								String occupancy,
								Authentication aut) {
		if(aut != null) {
			System.out.println("===================================================================================");
		    System.out.println("[INFO] INICIANDO BUSCA POR HOTEIS - POSSUI AUTHENTICATION");
		    System.out.println("===================================================================================");
		}
		else {
			System.out.println("===================================================================================");
		    System.out.println("[INFO] INICIANDO BUSCA POR HOTEIS - AUTHENTICATION VAZIO");
		    System.out.println("===================================================================================");
		}
		
		HttpHeaders headers = new HttpHeaders();

		headers.set("Authorization", aut.getType() + " " + aut.getAccessToken());
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<?> request = new HttpEntity<>(headers);

		UriComponents uri = UriComponentsBuilder.newInstance().scheme("http").host("api.infotravel.com.br")
				.path("api/v1/avail/hotel").queryParam("destination", destination).queryParam("start", start)
				.queryParam("end", end).queryParam("occupancy", occupancy).build();
		//return template.patchForObject(uri.toUriString(), headers, HotelAvail.class);
		System.out.println("===================================================================================");
	    System.out.println("[INFO] ENVIANDO REQUISIÇÃO PARA A URL: "+uri.toUriString());
	    System.out.println("===================================================================================");
		
		  ResponseEntity<SearchHotel> response = template.exchange(uri.toUriString(),
		  HttpMethod.GET, request, SearchHotel.class);


		return response.getBody();
	}
}
