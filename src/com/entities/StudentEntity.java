package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer id;
	@Column(name = "student_name")
	private String name;
	@Column(name = "father_name")
	private String fatherName;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	@Column(name = "student_department")
	private String department;
	@Column(name = "student_district")
	
	private String district;
	
	public StudentEntity(Integer id, String name, String fatherName, Date dateOfBirth, String department,String district) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.district = district;
	}
	
	public StudentEntity() {
		super();
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
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
	
	
}
