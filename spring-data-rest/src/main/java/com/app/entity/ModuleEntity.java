package com.app.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ModuleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "COURSE_ID")
	private int courseID;

	@Column(name = "MODULE_NAME")
	private String moduleName;

	@Column(name = "NOTES")
	private String notes;

	@Lob
	@Column(name = "VIDEO", columnDefinition = "LONGBLOB")
	private byte[] video;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public byte[] getVideo() {
		return video;
    }

	public void setVideo(byte[] video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "ModuleEntity [id=" + id + ", courseID=" + courseID + ", moduleName=" + moduleName + ", notes=" + notes
				+ ", video=" + video + "]";
	}
	

	
}