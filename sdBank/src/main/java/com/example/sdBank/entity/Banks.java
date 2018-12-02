package com.example.sdBank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banks {
@Id
Integer id;
String name;
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
}
