package com.example.demo.entities;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Attribute{
    public String name;
    public ArrayList<Item> items;
}