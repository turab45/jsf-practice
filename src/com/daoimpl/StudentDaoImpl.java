package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.StudentDao;
import com.entities.StudentEntity;
import com.util.Database;

public class StudentDaoImpl implements StudentDao{

	
	@Override
	public Integer addStudent(StudentEntity studentEntity) {
		Integer row = null;
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			row = (Integer) session.save(studentEntity);

			transaction.commit();
			System.out.println("Successfully saved student.");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer updateStudent(StudentEntity studentEntity) {
		Integer row = null;
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.update(studentEntity);
			row = 1;
			transaction.commit();
			System.out.println("Successfully updated student.");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer deleteStudent(StudentEntity studentEntity) {
		Integer row = null;
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.remove(studentEntity);
			row = 1;
			transaction.commit();
			System.out.println("Successfully deleted student.");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public StudentEntity getStudentById(Integer id) {
		StudentEntity studentEntity = null;
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			studentEntity = session.get(StudentEntity.class, id);

			transaction.commit();
			System.out.println("Successfully fetched student by id.");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return studentEntity;
	}

	@Override
	public StudentEntity getStudentByName(String name) {
		StudentEntity studentEntity = null;
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			Query query = session.createQuery("from StudentEntity e where e.name=:n");
			query.setParameter("n", name);
			
			studentEntity = (StudentEntity) query.getSingleResult();

			transaction.commit();
			System.out.println("Successfully fetched student by name.");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return studentEntity;
	}

	@Override
	public List<StudentEntity> getAllStudent() {
		List<StudentEntity> allStudents = new ArrayList<StudentEntity>();
		try {

			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			allStudents = session.createQuery("from StudentEntity").list();
			
			transaction.commit();
			System.out.println("Successfully fetched all students");

			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return allStudents;
	}

}
