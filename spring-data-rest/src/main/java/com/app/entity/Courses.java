package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Courses")
public class Courses {
	@Id
	@Column(name = "COURSE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Course_id;

	@Column(name = "COURSE_NAME")
	private String Course_name;

	@Column(name = "COURSE_DURATION")
	private String Course_duration;

	@Column(name = "START_DATE")
	private String Start_date;

	@Column(name = "END_DATE")
	private String End_date;

	@Column(name = "AVAILABILITY")
	private String Availability;

	@Column(name = "DETAILS")
	private String Details;

	@Column(name = "COURSE_PREREQUISITES")
	private String Course_prerequisites;

	@Column(name = "COURSE_OUTCOME")
	private String Course_outcome;

	public int getCourse_id() {
		return Course_id;
	}

	public void setCourse_id(int course_id) {
		Course_id = course_id;
	}

	public String getCourse_name() {
		return Course_name;
	}

	public void setCourse_name(String course_name) {
		Course_name = course_name;
	}

	public String getCourse_duration() {
		return Course_duration;
	}

	public void setCourse_duration(String course_duration) {
		Course_duration = course_duration;
	}

	public String getStart_date() {
		return Start_date;
	}

	public void setStart_date(String start_date) {
		Start_date = start_date;
	}

	public String getEnd_date() {
		return End_date;
	}

	public void setEnd_date(String end_date) {
		End_date = end_date;
	}

	public String getAvailability() {
		return Availability;
	}

	public void setAvailability(String availability) {
		Availability = availability;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public String getCourse_prerequisites() {
		return Course_prerequisites;
	}

	public void setCourse_prerequisites(String course_prerequisites) {
		Course_prerequisites = course_prerequisites;
	}

	public String getCourse_outcome() {
		return Course_outcome;
	}

	public void setCourse_outcome(String course_outcome) {
		Course_outcome = course_outcome;
	}

	@Override
	public String toString() {
		return "Courses [Course_id=" + Course_id + ", Course_name=" + Course_name + ", Course_duration="
				+ Course_duration + ", Start_date=" + Start_date + ", End_date=" + End_date + ", Availability="
				+ Availability + ", Details=" + Details + ", Course_prerequisites=" + Course_prerequisites
				+ ", Course_outcome=" + Course_outcome + "]";
	}

}
