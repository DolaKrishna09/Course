package com.app.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ImagesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COURSE_ID")
	private int id;

	@Lob
	@Column(name = "IMAGE", length = 1000)
	private byte[] image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ImagesEntity [id=" + id + ", image=" + Arrays.toString(image) + "]";
	}

	

}
