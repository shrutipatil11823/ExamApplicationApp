package org.com.service;
import java.util.*;

import org.com.repository.SubjectRepository;
import org.exam.model.SubjectModel;

public class SubjectService {
	SubjectRepository subRepo = new SubjectRepository();

	public int AddSubject(SubjectModel model, String name) 
	{
		return (subRepo.isSubjectPresent(model.getName())) ? -1 : subRepo.isAddSubject(model) ? 1 : 0;

//		boolean b=subReop.isAddSubject(model);
//		
//		if(b==true)
//		{
//			return 1;
//		}else
//		{
//			return 0;
//		}

	}
	
	public List<String> getAllSubjects()
	{
		return this.subRepo.getAllSubjects();
	}
}

