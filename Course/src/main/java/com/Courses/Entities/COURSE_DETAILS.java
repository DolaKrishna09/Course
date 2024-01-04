package com.Courses.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "COURSE_DETAILS_1")
public class COURSE_DETAILS {
	
	@Id
	@Column(name="COURSE_ID")
	private int Course_id;
	
	@Column(name="COURSE_NAME")
	private String Course_name;
	
	@Column(name="COURSE_DURATION")
	private String Course_duration;
	
	@Column(name="START_DATE")
	private String Start_date;
	
	@Column(name="END_ID")
	private String End_date;

	
	
	

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

	
	
	
	@Override
	public String toString() {
		return "COURSE_DETAILS [Course_id=" + Course_id + ", Course_name=" + Course_name + ", Course_duration="
				+ Course_duration + ", Start_date=" + Start_date + ", End_date=" + End_date + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
