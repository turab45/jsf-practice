package com.dao;

import java.util.List;

import com.entities.StudentEntity;

public interface StudentDao {
	public Integer addStudent(StudentEntity studentEntity);
	public Integer updateStudent(StudentEntity studentEntity);
	public Integer deleteStudent(StudentEntity studentEntity);
	public StudentEntity getStudentById(Integer id);
	public StudentEntity getStudentByName(String name);
	public List<StudentEntity> getAllStudent();

}
