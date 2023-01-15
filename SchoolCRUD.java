package com.ty.many_to_one_school_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.many_to_one_school_uni.dto.School;

public class SchoolCRUD {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveSchool(School school) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(school);

		entityTransaction.commit();

		System.out.println("Inserted successfully");
	}

	public void updateSchool(int id, School school) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		School receivedSchool = entityManager.find(School.class, id);

		if (receivedSchool != null) {
			school.setSid(id);

			entityTransaction.begin();
			entityManager.merge(school);

			entityTransaction.commit();
			System.out.println("Updated successfully");

		} else {
			System.out.println("this School id is not present");
		}

	}

	public void deleteSchool(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		School school = entityManager.find(School.class, id);

			entityTransaction.begin();
			entityManager.remove(school);

			entityTransaction.commit();
			System.out.println("Deleted successfully");

	}

	public School getSchoolById(int id) {
		EntityManager entityManager = getEntityManager();

		School school = entityManager.find(School.class, id);
		return school;

	}

	public List<School> getAllSchool() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select s from School s");
		List<School> list = query.getResultList();
		return list;

	}

}
