package org.exam.model;

import java.util.*;


public class ScheduleModel 
{
	private int schid;
	private Date date;
	private String starttime;
	private String endTime;
	private int examid;
	
	public ScheduleModel()
	{
		
	}
	
	ScheduleModel(int examid,Date date,String starttime,String endTime)
	{
		this.examid=examid;
		this.date=date;
		this.starttime=starttime;
		this.endTime=endTime;
	}
	
	
	public int getSchid() {
		return schid;
	}
	public void setSchid(int schid) {
		this.schid = schid;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	
}

