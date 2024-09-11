package org.exam.model;

public class StudentModel 
{
	private int stid;
	private String Name;
	private String Email;
	private String Contact;
	private String userName;
	private String PassWord;
	
	public StudentModel()
	{
		
	}
	
	public StudentModel(String Name,String Email,String Contact,String userName,String PassWord)
	{
		this.Name=Name;
		this.Email=Email;
		this.Contact=Contact;
		this.userName=userName;
		this.PassWord=PassWord;
	}
	
	public int getStid() {
		return stid;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

}
