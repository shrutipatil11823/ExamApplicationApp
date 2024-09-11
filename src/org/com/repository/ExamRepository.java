package org.com.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.exam.model.ExamModel;
import org.exam.model.ScheduleModel;

public class ExamRepository extends DBConfig {
	List<ExamModel> list = new ArrayList<ExamModel>();
	QuestionRepository qRepo=new QuestionRepository();

	public boolean isExamPresent(String name) {
		try {
			p = c.prepareStatement("select *from exam where Examname=?");
			p.setString(1, name);
			rs = p.executeQuery();
			return (rs.next());

		} catch (Exception ex) {
			System.out.println("Exception Occured " + ex);
		}
		return false;
	}

	public boolean isAddExam(ExamModel eModel) {
		try {
			p = c.prepareStatement("insert into exam values('0',?,?,?)");
			p.setString(1, eModel.getName());
			p.setInt(2, eModel.getTotalMarks());
			p.setInt(3, eModel.getPassingMarks());

			int value = p.executeUpdate();

			if (value > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println("Exception ex " + ex);
			return false;
		}
	}

	public List<ExamModel> getAllSubs() {
		try {
			p = c.prepareStatement("select *from exam");
			rs = p.executeQuery();

			while (rs.next()) {
				ExamModel model = new ExamModel();

				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setTotalMarks(rs.getInt(3));
				model.setPassingMarks(rs.getInt(4));

				list.add(model);
			}

			return list.size() > 0 ? list : null;

		} catch (Exception ex) {
			System.out.println("Exception ex " + ex);
			return null;
		}

	}

	public ExamModel getExamIdByName(String subName) {
		try {
			p = c.prepareStatement("select * from exam where Examname='" + subName + "'");
			rs = p.executeQuery();

			ExamModel model = null;

			if (rs.next()) {
				model = new ExamModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setTotalMarks(rs.getInt(3));
				model.setPassingMarks(rs.getInt(4));
			}

			return model != null ? model : null;

		} catch (Exception ex) {
			System.out.println("Exception ex " + ex);
			return null;
		}

	}

	
	public int getSchid() {
		
		int schId = 0;
		try {
			p = c.prepareStatement("select max(Schid) from schedule");
			rs = p.executeQuery();

			if (rs.next()) {
				schId=rs.getInt(1);
			}

			++schId;
			return schId;
			

		} catch (Exception ex) {
			System.out.println("Exception is " + ex);
			return 0;
		}

	}

	public boolean isSetSchedule(ExamModel model,String sname) {
		
		try {
			int Schid = this.getSchid();
			int sid=qRepo.getSubIdByName(sname);

			if (Schid != 0) 
			{
				ScheduleModel sch = model.getScheduleModel();
				String d = sch.getDate().toLocaleString();
				String d1[] = d.split(",");// year d1[1]
				String d2[] = d1[0].split(" ");// d2[0]=month d2[1]=date

			//	System.out.println(d2[1] + d2[0] + d1[1]);
				int months[] = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
				int m = 0;

				switch (d2[0].trim()) {
				case "Jan":
					m = 0;
					break;

				case "Feb":
					m = 1;
					break;

				case "Mar":
					m = 2;
					break;

				case "Apr":
					m = 3;
					break;

				case "May":
					m = 4;
					break;

				case "Jun":
					m = 5;
					break;

				case "July":
					m = 6;
					break;

				case "Aug":
					m = 7;
					break;

				case "Sept":
					m = 8;
					break;

				case "Oct":
					m = 9;
					break;

				case "Nov":
					m = 10;
					break;

				case "Dec":
					m = 11;
					break;
				}

				String year = d1[1].trim().substring(2, d1[1].trim().length());
				Date dt = new Date(Integer.parseInt(year) + 100, m, Integer.parseInt(d2[1]));

				p = c.prepareStatement("insert into schedule values(?,?,?,?,?,?)");
				p.setInt(1, Schid);
				p.setInt(2, model.getId());
				p.setDate(3, dt);
				p.setString(4,sch.getStarttime());
				p.setString(5,sch.getEndTime());
				p.setInt(6, sid);

				int value = p.executeUpdate();
				return value>0?true:false;

			} else {
				System.out.println("Some problem is there");
				return true;
			}

		} catch (Exception ex) {
			System.out.println("Exception ex " + ex);
		}

		return true;

	}
}
