package de.javaakademie.microservices.comic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comic {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String category;

	public Comic() {
		super();
	}

	public Comic(String name) {
		this.setName(name);
	}

	public Comic(String name, String category) {
		this.name = name;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}