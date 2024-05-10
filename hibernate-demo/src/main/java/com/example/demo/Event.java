package com.example.demo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//makes class an entity
@Entity
//explicitly specifies the name of the mapped table.
@Table(name = "Events")
public class Event {

	public Event() {

	}

	public Event(String title, LocalDateTime date) {
		this.title = title;
		this.date = date;
	}

	// makes the field as holding the identifier of the entity
	@Id
	// specifies that the id is synthetic and sytem generated
	@GeneratedValue
	private Long id;

	private String title;

	// specifies the name of the column
	@Column(name = "eventDate")
	private LocalDateTime date;

	public String getTitle() {
		return this.title;
	}

	public LocalDateTime getDate() {
		return this.date;
	}

}
