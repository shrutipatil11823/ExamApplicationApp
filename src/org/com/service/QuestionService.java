package org.com.service;

import java.io.*;
import org.com.repository.QuestionRepository;
import org.exam.helper.PathHelper;
import org.exam.model.QuestionModel;
import java.util.*;

public class QuestionService {
	QuestionRepository qRepo = new QuestionRepository();
	SubjectService ss = new SubjectService();

	public boolean isAddQuestion(QuestionModel qModel, String name) {
		return qRepo.isAddQuestion(qModel, name);
	}

	public boolean createFile() {
		String path = "C:\\Users\\91808\\eclipse-workspace\\ExamApplication\\QuestionBank\\";
		try {
			File fl = new File(path);

			if (!fl.exists()) {
				fl.mkdir();
			}

			List<String> subList = ss.getAllSubjects();

			if (subList != null) {
				for (String subName : subList) {
					fl = new File(path + "\\" + subName + ".csv");
					if (!fl.exists()) {
						fl.createNewFile();
					}

				}

			} else {
				System.out.println("Subject not found!");
			}

		} catch (Exception ex) {
			System.out.println("Exception is " + ex);
		}

		return true;
	}

	
	public boolean uploadBulkQuestion(String subName) {
		boolean b = this.createFile();
		boolean flag =true;

		if (b) 
		{
			File f=new File("C:\\Users\\91808\\eclipse-workspace\\ExamApplication\\QuestionBank\\");
			
			File []Files=f.listFiles();
			
			for(File file:Files)
			{
				int index=file.toString().indexOf(subName);
				
				if(index!=-1)
				{
					flag=true;
					break;
				}
			}
			
			if(flag==true)
			{
				try {
					FileReader fr=new FileReader(PathHelper.filepath+"\\"+subName+".csv");
					BufferedReader br=new BufferedReader(fr);
					
					String question;
					flag=false;
					while((question=br.readLine())!=null)
					{
						String queWithOption[]=question.split(",");
						flag=qRepo.uploadBulkQuestion(queWithOption, subName);
					}
					
				} catch (Exception e) {
				
					System.out.println("Exception is "+e);
				}
			}else
			{
				System.out.println("Subject is not found to add bulk question");
			}
			
		} 

		return false;
	}
	
}
