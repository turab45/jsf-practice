package com.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.dao.StudentDao;
import com.daoimpl.StudentDaoImpl;
import com.entities.StudentEntity;


// Author: Turab45

@ManagedBean(name = "studentMB")
@RequestScoped
public class StudentManagedBean {
	private Integer id;
	private String name;
	private String fatherName;
	private Date dateOfBirth;
	private String department;
	private String district;
	
	
	private StudentDao studentDaoImpl = null;
	private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  
	
	public StudentManagedBean() {
		super();
		
		studentDaoImpl = new StudentDaoImpl();
		
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
	
	
	public List<StudentEntity> getAllStudents(){
		List<StudentEntity> allStudents = null;
		
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		allStudents = studentDaoImpl.getAllStudent();
		
		return allStudents;
	}
	
	public String add() {
		System.out.println("Name          : "+this.name);
		System.out.println("Father Name   : "+this.fatherName);
		System.out.println("Date of Birth : "+this.dateOfBirth);
		System.out.println("Department    : "+this.department);
		System.out.println("District      : "+this.district);
		
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setName(this.name);
		studentEntity.setFatherName(this.fatherName);
		studentEntity.setDepartment(this.department);
		studentEntity.setDistrict(this.district);
		
		studentDaoImpl.addStudent(studentEntity);
		
		this.name = null;
		this.fatherName = null;
		return "";
	}
	
	public String update(Integer id) {
		StudentEntity studentEntity = studentDaoImpl.getStudentById(id);
		this.name = studentEntity.getName();
		this.fatherName = studentEntity.getFatherName();
		this.department = studentEntity.getDepartment();
		this.district = studentEntity.getDistrict();
		
		sessionMap.put("editUser", studentEntity);
		
		return "edit.xhtml";
	}
	
	public String update(StudentEntity entity) {
		
		
		entity.setName(this.name);
		entity.setFatherName(this.fatherName);
		entity.setDepartment(this.department);
		entity.setDistrict(this.district);
		
		studentDaoImpl.updateStudent(entity);
		this.name = null;
		this.fatherName = null;
		return "index.xhtml";
	}
	
	public String delete(Integer id) {
		StudentEntity studentEntity = studentDaoImpl.getStudentById(id);
		studentDaoImpl.deleteStudent(studentEntity);
		System.out.println("Deleting...");
		return "";
	}
	
	public String cancel() {
		this.name = null;
		this.fatherName = null;
		return "index.xhtml";
	}
	

}
