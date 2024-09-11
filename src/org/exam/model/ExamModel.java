package org.exam.model;

import java.sql.Date;
import org.exam.model.ScheduleModel;

public class ExamModel 
{
	private int id;
	private String name;
	private int totalMarks;
	private int passingMarks;
	ScheduleModel scheduleModel;

	public ExamModel()
	{
		
	}
	
	public ExamModel(String name,int totalMarks,int passingMarks)
	{
		this.name=name;
		this.totalMarks=totalMarks;
		this.passingMarks=passingMarks;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getPassingMarks() {
		return passingMarks;
	}
	public void setPassingMarks(int passingMarks) {
		this.passingMarks = passingMarks;
	}

	public ScheduleModel getScheduleModel() {
		return scheduleModel;
	}

	public void setScheduleModel(ScheduleModel scheduleModel) {
		this.scheduleModel = scheduleModel;
	}
	
}

