package org.exam.client;


//17 23.14


import org.com.repository.QuestionRepository;
import org.com.repository.StudentRepository;
import org.com.service.ExamService;
import java.time.LocalDate; 
import org.com.service.QuestionService;
import org.com.service.StudentService;
import org.com.service.SubjectService;
import org.exam.model.ExamModel;
import org.exam.model.QuestionModel;
import org.exam.model.ScheduleModel;
import org.exam.model.StudentModel;
import org.exam.model.SubjectModel;


import java.util.*;

public class ExamClientApplication {
	public static void main(String a[]) {
		SubjectService sv = new SubjectService();
		QuestionService qs = new QuestionService();
		ExamService es=new ExamService();
		QuestionRepository qr=new QuestionRepository();
		StudentService  ss=new StudentService();
		StudentRepository sr=new StudentRepository();
		
		int choice;
		int subid;

		do {
			System.out.println("0.Enter 0 to exit");
			System.out.println("1.Add New Subject");
			System.out.println("2.Add Single Question");
			System.out.println("3.Add Bulk Questions");
			System.out.println("4.Add Exam");
			System.out.println("5.Create exam schedule");
			System.out.println("6.Add student and check exam");
			
			System.out.println("Enter your choice");

			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				System.out.println("You are successfully exited!");
				break;

			case 1:

				sc.nextLine();
				System.out.println("Enter subject name");
				String name = sc.nextLine();

				SubjectModel model = new SubjectModel();
				model.setName(name);

				int result = sv.AddSubject(model, name);

				if (result == -1) {
					System.out.println("Subject already present");
				} else if (result == 1) {
					System.out.println("Subject Added Successfully.....");
				} else {
					System.out.println("Some Problem Is There.....");
				}

				break;

			case 2:
				sc.nextLine();
				System.out.println("Enter question");
				String ques = sc.nextLine();
				System.out.println("Enter op1");
				String Op1 = sc.nextLine();
				System.out.println("Enter op2");
				String Op2 = sc.nextLine();
				System.out.println("Enter op3");
				String Op3 = sc.nextLine();
				System.out.println("Enter op4");
				String Op4 = sc.nextLine();
				System.out.println("Enter ans");
				int ans = sc.nextInt();

				sc.nextLine();
				System.out.println("Enter subject name");
				String subName = sc.nextLine();
				QuestionModel qModel = new QuestionModel(ques, Op1, Op2, Op3, Op4, ans);

				boolean b = qs.isAddQuestion(qModel, subName);

				if (b) {
					System.out.println("Question added successfully");
				} else {
					System.out.println("Some problem is there");
				}

				break;
				
			case 3:
				sc.nextLine();
				System.out.println("Enter Subject to enter question");
				String Subname=sc.nextLine();
				if(qs.uploadBulkQuestion(Subname))
				{
					System.out.println("Bulk question added");
				}
				else
				{
					System.out.println("Bulk Question is not added");
				}
				break;
				
			case 4:
				sc.nextLine();
				System.out.println("Enter exam name,Total Marks and Passing Marks");
				name=sc.nextLine();
				int totalMarks=sc.nextInt();
				int passingMarks=sc.nextInt();
				
				ExamModel eModel=new ExamModel(name,totalMarks,passingMarks);
				
				int b1=es.isAddExam(eModel);
				if(b1==1)
				{
					System.out.println("Exam added successfully.........");
				}else if(b1==-1)
				{
					System.out.println("Exam already present..........");
				}else
				{
					System.out.println("Some problem is there......");
				}
				
				break;
				
			case 5:
				System.out.println("Exams and details to select schedule");
			
				
				List<ExamModel> list=es.getAllSubs();
				
				for(ExamModel lst:list)
				{
					System.out.println(lst.getId()+"\t"+lst.getName()+"\t"+lst.getTotalMarks()+"\t"+lst.getPassingMarks());
				}
				
				System.out.println("Enter Exam name to see schedule");
				sc.nextLine();
				name=sc.nextLine();
				
				eModel=es.getExamIdByName(name);
				
				if(eModel!=null)
				{
					System.out.println("Enter exam date,start Time and End time");
					String dateFormat=sc.nextLine();   //27-02-2024
					Date d1=new Date(dateFormat);
					String startTime=sc.nextLine();
					String endTime=sc.nextLine();
					ScheduleModel smodel=new ScheduleModel();
					smodel.setDate(d1);
					smodel.setStarttime(startTime);
					smodel.setEndTime(endTime);
					eModel.setScheduleModel(smodel);
					
					System.out.println("Enter subject name");
					String sname=sc.nextLine();
					b=es.isSetSchedule(eModel,sname);
					
					if(b)
					{
						System.out.println("Schedule added successfully.......");
					}else
					{
						System.out.println("Exam not scheduled.....");
					}
				}
				else
				{
					System.out.println("Enter correct exam name");
				}
				
				break;
				
			case 6:
				sc.nextLine();
				System.out.println("Enter name,email,contact,username and password");
				String names,email,contact,username,password;
				names=sc.nextLine();
				email=sc.nextLine();
				contact=sc.nextLine();
				username=sc.nextLine();
				password=sc.nextLine();
				
				StudentModel sModel=new StudentModel(names,email,contact,username,password);
				System.out.println("Enter Subject Name");
				name=sc.nextLine();
				b=ss.addStudentData(sModel,name,names);
				
				if(b)
				{
					System.out.println("Data added");
				}else
				{
					System.out.println("Data not added");
				}
				
				System.out.println("Enter username and password to check is it valid");
				username=sc.nextLine();
				password=sc.nextLine();
				b=ss.checkValidStudentData(sModel, username, password);
				
				System.out.println("Enter how many record do you want to insert");
				
				int rec=sc.nextInt();
				int i=0;
				
				while(i<rec)
				{
					sc.nextLine();
					System.out.println("enter your name and subject name");
					
					names=sc.nextLine();
					name=sc.nextLine();
					
					int stid=sr.getStudentIdByName(names);
					int sid=sr.getSubIdByName(name);
					
					System.out.println("Student id and subject id for subject is"+names+" "+stid+" "+name+" "+sid);
					i++;
				}
				
						
				break;

			default:
				System.out.println("Invalid choice!");
				break;

			}

		} while (choice != 0);

	}
}

