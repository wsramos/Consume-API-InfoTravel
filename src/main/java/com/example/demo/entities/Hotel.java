package com.example.demo.entities;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Hotel{
    
	public Integer id;
    public String keyDetail;
    public String name;
    public String description;
    public Address address;
    public Double stars;
    public ArrayList<Image> images;
    public ArrayList<Attribute> attributes;
       
}
