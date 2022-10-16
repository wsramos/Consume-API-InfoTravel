package com.example.demo.entities;

public class Teste {
	
	private Integer id;
	private String name;
	
	public Teste(){
		this.id = 1;
		this.name = "Teste";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Teste [id=" + id + ", name=" + name + "]";
	}
	
	
}
