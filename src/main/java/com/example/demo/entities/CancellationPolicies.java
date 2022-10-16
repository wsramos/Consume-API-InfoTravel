package com.example.demo.entities;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CancellationPolicies{
    public boolean refundable;
    public ArrayList<Penalty> penalties;
}
