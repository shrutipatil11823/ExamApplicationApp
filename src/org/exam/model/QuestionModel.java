package org.exam.model;

public class QuestionModel {
	private int id;
	private String name;
	private String Op1;
	private String Op2;
	private String Op3;
	private String Op4;
	private int ans;

	QuestionModel() {

	}

	public QuestionModel(String name, String Op1, String Op2, String Op3, String Op4, int ans) {
		this.name = name;
		this.Op1 = Op1;
		this.Op2 = Op2;
		this.Op3 = Op3;
		this.Op4 = Op4;
		this.ans = ans;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOp1() {
		return Op1;
	}

	public void setOp1(String op1) {
		Op1 = op1;
	}

	public String getOp2() {
		return Op2;
	}

	public void setOp2(String op2) {
		Op2 = op2;
	}

	public String getOp3() {
		return Op3;
	}

	public void setOp3(String op3) {
		Op3 = op3;
	}

	public String getOp4() {
		return Op4;
	}

	public void setOp4(String op4) {
		Op4 = op4;
	}

	public int getAns() {
		return ans;
	}

	public void setAns(int ans) {
		this.ans = ans;
	}
}
