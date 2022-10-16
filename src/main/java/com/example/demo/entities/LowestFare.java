package com.example.demo.entities;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LowestFare{
    
	public RoomType roomType;
    public ArrayList<Fare> fares;
    public ArrayList<BoardType> boardTypes;
    public CancellationPolicies cancellationPolicies;
    public String checkIn;
    public String checkOut;
    
}
