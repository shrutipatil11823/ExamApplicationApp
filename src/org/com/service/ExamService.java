package org.com.service;

import java.util.*;

import org.com.repository.ExamRepository;
import org.exam.model.ExamModel;
import org.exam.model.ScheduleModel;

public class ExamService 
{
	ExamRepository eRepo=new ExamRepository();
	
	public int isAddExam(ExamModel eModel)
	{
		return eRepo.isAddExam(eModel)?1:eRepo.isExamPresent(eModel.getName())?-1:0;
	}
	
	public List<ExamModel> getAllSubs()
	{
		return eRepo.getAllSubs();	
	}
	
	public ExamModel getExamIdByName(String name)
	{
		return eRepo.getExamIdByName(name);
	}
	
	public boolean isSetSchedule(ExamModel model, String sname)
	{
		Date d =new Date();
		String s[]=d.toLocaleString().split(",");
	//	System.out.println(s[0]+s[1]);
		
		String Monsplit[]=s[0].split(" ");
		ScheduleModel smodel=model.getScheduleModel();
		Date userDate=smodel.getDate();
	//	System.out.println("User Date is "+userDate.toLocaleString());//feb 27,2024,12
		
		String userDateArr[]=userDate.toLocaleString().split(",");  //27-Feb-2024
		String userDateArrNew[]=userDateArr[0].split(" ");	
		
		int currentDay = Integer.parseInt(userDateArr[1].trim());
		int userDay = Integer.parseInt(s[1].trim());
		
		if((currentDay >= userDay) && (userDateArrNew[0]).equals(Monsplit[0]) )
		{
			if(Integer.parseInt(userDateArrNew[1])>=Integer.parseInt(Monsplit[1]))
			{
				System.out.println("You can sheduled exam");
				return eRepo.isSetSchedule(model,sname)?true:false;
			}else
			{
				System.out.println("You should have to enter wright date");
			}
		}else
		{
			System.out.println("you should have to enter wright month or year");
		}
		
//		System.out.println("Date is "+Monsplit[1]);
//		System.out.println("Month is "+Monsplit[0]);
//		System.out.println("Year is"+s[1]);
		
		return false;
		
	}
}

