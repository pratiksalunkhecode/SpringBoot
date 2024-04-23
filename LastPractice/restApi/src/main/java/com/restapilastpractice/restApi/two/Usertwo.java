package com.restapilastpractice.restApi.two;

import java.time.LocalDate;

import org.hibernate.annotations.BatchSize;
import org.springframework.boot.convert.DataSizeUnit;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Usertwo {
    
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2, message = "please enter 2>= charecter")
	//@JsonProperty("User_Name")
	private String name;
	//@JsonProperty("janam_din")
	private LocalDate birthdate;

	public Usertwo(Integer id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "Usertwo [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}

}
