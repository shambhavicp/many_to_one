package com.ty.many_to_one_school_uni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.many_to_one_school_uni.dao.SchoolCRUD;
import com.ty.many_to_one_school_uni.dao.StudentCRUD;
import com.ty.many_to_one_school_uni.dao.TeacherCRUD;

import com.ty.many_to_one_school_uni.dto.School;
import com.ty.many_to_one_school_uni.dto.Student;
import com.ty.many_to_one_school_uni.dto.Teacher;


public class SchoolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		
		
		StudentCRUD studentCRUD=new StudentCRUD();
			
		TeacherCRUD teacherCRUD=new TeacherCRUD();
		
		SchoolCRUD schoolCRUD=new SchoolCRUD();
		
		Scanner scanner=new Scanner(System.in);
		boolean exit =true;
		
		do {
			System.out.println("To Which one u want to perform CRUD Operations");
			System.out.println(" 1.School \n 2.Teacher \n 3.Student \n 4.Exit");
			System.out.println("Enter your choice");
		
			int choice=scanner.nextInt();
			switch(choice) {
			
			case 1: {
				
				boolean exit1=true;
				do {
					System.out.println("Which Operation u want to perform ");
					System.out.println(" 1.Insert data \n 2.Update data \n 3.Delete data \n 4.Get the School data by id \n 5.Get all data \n 6.Exit ");
					System.out.println("Enter your choice ");
					int choice1=scanner.nextInt();
					
					switch(choice1) {

					case 1:{
					
						System.out.println("Enter the school id");
						int sid =scanner.nextInt();
						
						System.out.println("Enter the school name");
						String name=scanner.next();
						
						System.out.println("Enter the school address");
						String address=scanner.next();
						
						System.out.println("Enter the school fees");
						double fees=scanner.nextDouble();
						
						School school=new School();
						school.setSid(sid);
						school.setName(name);
						school.setAddress(address);
						school.setFees(fees);
						
						schoolCRUD.saveSchool(school);
					}
					break;
					
					case 2:{
						System.out.println("Enter the school id to be updated");
						int sid =scanner.nextInt();
						
						System.out.println("Enter the name");
						String name=scanner.next();
						
						School school=new School();
						school.setSid(sid);
						school.setName(name);
						
						schoolCRUD.updateSchool(sid, school);
						
					}
					break;
					
					case 3:{
						System.out.println("Enter the school id to be deleted");
						int sid =scanner.nextInt();
					
						School school=new School();
						school.setSid(sid);
						
						schoolCRUD.deleteSchool(sid);
					}
					break;
					
					case 4:{
						System.out.println("Enter the school id to get the details");
						int sid =scanner.nextInt();
						
						System.out.println(schoolCRUD.getSchoolById(sid));
						
						
					}
					break;
					
					case 5:{
						System.out.println(schoolCRUD.getAllSchool()); 
					}
					break;
					
					case 6:{
						exit1=false;
						System.out.println("Thank u");
						
					}
					
					break;
					
					default:System.out.println("Invalid choice");
					}
				
				}while(exit1);
				
				
			}
			break;
			
			case 2:{
					boolean exit2 =true;
					
					do {
					System.out.println("Which Operation u want to perform ");
					System.out.println(" 1.Insert data \n 2.Update data \n 3.Delete data \n 4.Get the Teacher data by id \n 5.Get all data \n 6.Exit ");
					System.out.println("Enter your choice ");
					
					int choice2=scanner.nextInt();
					switch(choice2) {
					case 1:{
			
						System.out.println("Enter the Teacher name");
						String name=scanner.next();
						
						System.out.println("Enter the Teacher address");
						String address=scanner.next();
						
						System.out.println("Enter the school id");
						int schoolId=scanner.nextInt();
						
						Teacher teacher=new Teacher();
						
						teacher.setName(name);
						teacher.setAddress(address);
			
						School school=new School();
						teacher.setSchool(school);
					
				
						teacherCRUD.saveTeacher(teacher, schoolId);
						
					}
					break;
					
					case 2:{
						
						System.out.println("Enter the Teacher id to be updated");
						int id =scanner.nextInt();
						
						System.out.println("Enter the name");
						String name=scanner.next();
						Teacher teacher=new Teacher();
						
						teacher.setId(id);
						teacher.setName(name);
						
						teacherCRUD.updateTeacher(id, teacher);
					}
					break;
					
					case 3:{
						System.out.println("Enter the teacher id to be deleted");
						int id =scanner.nextInt();
					
						
						teacherCRUD.deleteTeacher(id);						
						
					}
					break;
					
					case 4:{
						System.out.println("Enter the teacher id to get the details");
						int id =scanner.nextInt();
						
						System.out.println(teacherCRUD.getTeacherById(id));
						
					}
					break;
					case 5:{
						System.out.println(teacherCRUD.getAllTeacher()); 
					}
					break;
					case 6:{
						exit2=false;
						System.out.println("Thank u");
						
					}
					break;
					
					default:System.out.println("Invalid choice");
					}
					}while(exit2);
					
				
			}
			break;
			
			
			case 3:{
				
					boolean exit3 =true;
					
					do {
					System.out.println("Which Operation u want to perform ");
					System.out.println(" 1.Insert data \n 2.Update data \n 3.Delete data \n 4.Get the Student data by id \n 5.Get all data \n 6.Exit ");
					System.out.println("Enter your choice ");
					
					int choice3=scanner.nextInt();
					switch(choice3) {
					case 1:{
						
						System.out.println("Enter the student name");
						String name=scanner.next();
						
						System.out.println("Enter the student address");
						String address=scanner.next();
						
						System.out.println("Enter the student marks");
						int marks=scanner.nextInt();
						
						System.out.println("Enter the school id");
						int schoolId=scanner.nextInt();
						
						Student student=new Student();
						student.setName(name);
						student.setAddress(address);
						student.setMarks(marks);
						
						School school=new School();
						student.setSchool(school);
						
						studentCRUD.saveStudent(student, schoolId);
						
					}
					break;
					
					case 2:{
						
						System.out.println("Enter the student id to be updated");
						int id =scanner.nextInt();
						
						System.out.println("Enter the name");
						String name=scanner.next();
						
						Student student=new Student();
						student.setId(id);
						student.setName(name);
						
						studentCRUD.updateStudent(id, student);
					}
					break;
					
					case 3:{
						System.out.println("Enter the student id to be deleted");
						int id =scanner.nextInt();
					
						
						studentCRUD.deleteStudent(id);						
						
						
					}
					break;
					
					case 4:{
						System.out.println("Enter the student id to get the details");
						int id =scanner.nextInt();
						
						System.out.println(studentCRUD.getStudentById(id));
						
					}
					break;
					case 5:{
						System.out.println(studentCRUD.getAllStudent()); 
					}
					break;
					case 6:{
						exit3=false;
						System.out.println("Thank u");
						
					}
					break;
					
					default:System.out.println("Invalid choice");
					}
					}while(exit3);
				
				
				
			}
			break;
	
			case 4:{
				exit=false;
				System.out.println("Thank u");
				
			}
			break;
			default :System.out.println("Invalid Choice");
			}
			
		}while(exit);

	}

}
