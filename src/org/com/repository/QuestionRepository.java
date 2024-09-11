package org.com.repository;

import org.exam.model.QuestionModel;

public class QuestionRepository extends DBConfig 
{
	private int questionId;

	private int getQustionId() {
		try {
			p = c.prepareStatement("select max(qid) from question");
			rs = p.executeQuery();

			if (rs.next()) {
				questionId = rs.getInt(1);
			}
			++questionId;
		} catch (Exception ex) {
			System.out.println("Exception ex " + ex);
			return 0;
		}
		return questionId;
	}

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

	public boolean isAddQuestion(QuestionModel qModel, String name)
	{

		int qid = this.getQustionId();

		try {
			if (qid != 0) {
				p = c.prepareStatement("insert into question values(?,?,?,?,?,?,?)");

				p.setInt(1, qid);
				p.setString(2, qModel.getName());
				p.setString(3, qModel.getOp1());
				p.setString(4, qModel.getOp2());
				p.setString(5, qModel.getOp3());
				p.setString(6, qModel.getOp4());
				p.setInt(7, qModel.getAns());

				int value = p.executeUpdate();

				if (value > 0) {

					int sid = this.getSubIdByName(name);

					if (sid != -1) {
						p = c.prepareStatement("insert into subjectquestionjoin values(?,?)");
						p.setInt(1, sid);
						p.setInt(2, qid);

						return p.executeUpdate() > 0 ? true : false;
					} else if (sid == -1) {
						System.out.println("Subject not found");
						return false;
					} else {
						System.out.println("Some problem is there");
						return false;
					}

				} else {
					return false;
				}

			} else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println("Exception is" + ex);
			return false;
		}
		
	}
	
	public boolean uploadBulkQuestion(String[] queWithop,String subName) 
	{
		int qid = this.getQustionId();

		try {
			if (qid != 0) {
				p = c.prepareStatement("insert into question values(?,?,?,?,?,?,?)");

				p.setInt(1, qid);
				p.setString(2, queWithop[0]);
				p.setString(3, queWithop[1]);
				p.setString(4, queWithop[2]);
				p.setString(5, queWithop[3]);
				p.setString(6, queWithop[4]);
				p.setInt(7, Integer.parseInt(queWithop[5].trim()));

				int value = p.executeUpdate();

				if (value> 0)
				{
					int sid = this.getSubIdByName(subName);

					if (sid != -1) {
						p = c.prepareStatement("insert into subjectquestionjoin values(?,?)");
						p.setInt(1, sid);
						p.setInt(2, qid);

						return p.executeUpdate() > 0 ? true : false;
					} else if (sid == -1) {
						System.out.println("Subject not found");
						return false;
					} else {
						System.out.println("Some problem is there");
						return false;
					}

				} else {
					return false;
				}

			} else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println("Exception is" + ex);
			return false;
		}
	}
}
