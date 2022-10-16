package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.HotelDetail;
import com.example.demo.entities.SearchHotel;
import com.example.demo.services.AuthenticationService;
import com.example.demo.services.HotelService;
import com.example.demo.services.SearchService;

@RestController
@RequestMapping(value="/hoteis")
public class HoteisController {
	
	@Autowired
	private SearchService searchService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private AuthenticationService aut;
	
	@GetMapping("/search")
	public SearchHotel getHotelAvail(@RequestParam String destination, 
			@RequestParam String start, 
			@RequestParam String end,
			@RequestParam String occupancy) {
		return searchService.getHoteis(destination, start, end, occupancy, aut.getAuthentication());
	}
	
	@GetMapping("/hotel")
	public HotelDetail getHotelDetail(@RequestParam String keyDetail) {
		return hotelService.getHotel(keyDetail, aut.getAuthentication());
	}
}
