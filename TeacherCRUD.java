package com.ty.many_to_one_school_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.many_to_one_school_uni.dto.School;
import com.ty.many_to_one_school_uni.dto.Teacher;

public class TeacherCRUD {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveTeacher(Teacher teacher, int schoolId) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		
		School school = entityManager.find(School.class, schoolId);
		if(school!=null) {
			//school.setSid(schoolId);
		teacher.setSchool(school);

		entityTransaction.begin();
		//entityManager.merge(teacher.getSchool());
		entityManager.persist(teacher);

		entityTransaction.commit();
		System.out.println("data inserted");
		}else {
			System.out.println("add school first");
		}

	}

	public void updateTeacher(int id, Teacher teacher) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Teacher receivedTeacher = entityManager.find(Teacher.class, id);

		if (receivedTeacher != null) {

			receivedTeacher.setId(id);
			receivedTeacher.setName(teacher.getName());
			//teacher.setSchool(teacher.getSchool());

			entityTransaction.begin();

			entityManager.merge(receivedTeacher);

			entityTransaction.commit();

			System.out.println("Updated successfully");

		} else {
			System.out.println("teacher id is not present");
		}

	}

	public void deleteTeacher(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Teacher teacher = entityManager.find(Teacher.class, id);

		if (teacher != null) {
			teacher.setId(id);

			entityTransaction.begin();
			entityManager.remove(teacher);

			entityTransaction.commit();

			System.out.println("Deleted successfully");

		} else {
			System.out.println("Teacher id is not present");
		}

	}

	public Teacher getTeacherById(int id) {
		EntityManager entityManager = getEntityManager();

		Teacher teacher = entityManager.find(Teacher.class, id);
		return teacher;

	}

	public List<Teacher> getAllTeacher() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select t from Teacher t");
		List<Teacher> list = query.getResultList();
		return list;

	}

}
