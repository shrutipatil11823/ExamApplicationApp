package org.com.service;

import org.com.repository.StudentRepository;
import org.exam.model.StudentModel;

public class StudentService 
{
	StudentRepository sRepo=new StudentRepository();
	public boolean addStudentData(StudentModel sMdel,String name,String subName)
	{
		return sRepo.addStudentData(sMdel,name,subName);
		
	}
	
	public boolean checkValidStudentData(StudentModel sMdel,String name,String pass)
	{
		return sRepo.checkValidStudentData(sMdel, name, pass);
		
	}
}
