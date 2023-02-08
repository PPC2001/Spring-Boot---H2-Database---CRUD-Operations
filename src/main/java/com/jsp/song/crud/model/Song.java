package com.jsp.song.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "song")
public class Song {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private double duration;

	public Song() {

	}

	public Song(String title, double duration) {
		this.title = title;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", duration=" + duration + "]";
	}
}
