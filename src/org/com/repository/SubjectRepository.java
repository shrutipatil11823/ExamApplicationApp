package org.com.repository;
import java.util.*;
import org.exam.model.SubjectModel;

public class SubjectRepository extends DBConfig
{
	List<String> list=new ArrayList<String>();
	
	public boolean isAddSubject(SubjectModel model) {
		try {
			p = c.prepareStatement("insert into subject values('0',?)");
			p.setString(1, model.getName());

			int value = p.executeUpdate();

			if (value > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println("Exception occured : " + ex);
			return false;
		}
	}

	public boolean isSubjectPresent(String name) {
		try {
			p = c.prepareStatement("select *from subject where Subjectname=?");
			p.setString(1, name);
			rs = p.executeQuery();

			return (rs.next());

		} catch (Exception ex) {
			// System.out.println("Exception occured :"+ex);
			return false;
		}
	}
	
	public List<String> getAllSubjects()
	{
		try
		{
			p=c.prepareStatement("select Subjectname from subject");	
			rs=p.executeQuery();
			
			while(rs.next())
			{
				list.add(rs.getString("Subjectname"));
			}
			
			return (list.size()>0?list:null);
			
		}catch(Exception ex)
		{
			System.out.println("Exception ex "+ex);
			return null;
		}
		
	}
}











