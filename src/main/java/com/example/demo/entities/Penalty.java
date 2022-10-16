package com.example.demo.entities;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Penalty{
    public Date from;
    public String description;
}
