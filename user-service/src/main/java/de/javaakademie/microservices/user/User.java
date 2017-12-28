package de.javaakademie.microservices.user;

import java.util.List;

import de.javaakademie.microservices.user.intercomm.Comic;

public class User {

	private Integer id;

	private String name;

	private List<Comic> comics;

	public User() {

	}

	public User(Integer id, String name) {
		this.id = id;
		this.name = name;
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

	public List<Comic> getComics() {
		return comics;
	}

	public void setComics(List<Comic> comics) {
		this.comics = comics;
	}

}
