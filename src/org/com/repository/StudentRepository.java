package org.com.repository;

import org.exam.model.StudentModel;

public class StudentRepository extends DBConfig
{
	public int getSubIdByName(String name) {
		try {
			p = c.prepareStatement("select sid from subject where Subjectname=?");
			p.setString(1, name);

			rs = p.executeQuery();
			if (rs.next()) { 
				return (rs.getInt(1));
			} else {
				return -1;
			}

		} catch (Exception ex) {
			System.out.println("Exception is" + ex);
			return 0;
		}
	}
	
	public int getStudentIdByName(String stdname) {
		try {
			p = c.prepareStatement("select Stid from student where Name=?");
			p.setString(1, stdname);

			rs = p.executeQuery();
			
			
			if (rs.next()) { 
				return (rs.getInt(1));
			} else {
				return -1;
			}

		} catch (Exception ex) {
			System.out.println("Exception is" + ex);
			return 0;
		}
	}
	
	public boolean addStudentData(StudentModel sModel,String name,String stdName)
	{
		try
		{
			p=c.prepareStatement("insert into Student values('0',?,?,?,?,?)");
			p.setString(1,sModel.getName());
			p.setString(2,sModel.getEmail());
			p.setString(3,sModel.getContact());
			p.setString(4,sModel.getUserName());
			p.setString(5,sModel.getPassWord());
			
			int value=p.executeUpdate();
			
			if(value>0)
			{
				int sid = this.getSubIdByName(name);
				int stid=this.getStudentIdByName(stdName);
				System.err.println(stid+" "+sid);
				if (sid != -1) {
					p = c.prepareStatement("insert into studentsubjectjoin values(?,?)");
					p.setInt(1, stid);
					p.setInt(2, sid);

					return p.executeUpdate() > 0 ? true : false;
				} else if (sid == -1) {
					System.out.println("Subject not found");
					return false;
				} else {
					System.out.println("Some problem is there");
					return false;
				}
			}else
			{
				return false;
			}
		}catch(Exception ex)
		{
			System.out.println("Excetioon is "+ex);
			return false;
		}		
		
	}
	
	public boolean checkValidStudentData(StudentModel sMdel,String name,String pass)
	{
		try
		{
			p=c.prepareStatement("select Username,password from student where Username=? and password=?");
			p.setString(1,name);
			p.setString(2,pass);
			rs=p.executeQuery();
			
			while(rs.next())
			{
				String username=rs.getString("Username");
				String passw=rs.getString("password");
				
				if(username.equals(name) && passw.equals(passw))
				{
					System.out.println("Entered valid username and password");
				}else
				{
					System.out.println("Please Entere valid username and password");
				}
			}
			
			return true;
			
		}catch(Exception ex)
		{
			System.out.println("Excetioon is "+ex);
			return false;
		}			
		
	}
}
