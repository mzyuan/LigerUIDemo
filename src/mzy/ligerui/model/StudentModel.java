package mzy.ligerui.model;

import java.util.Date;

public class StudentModel {

	//属性
	private int id;
	private String stuname;
	private String stunumber;
	private String stusex;
	private Date stubirth;
	private String stumark;
	private String stuaddress;
	private String stuphone;
	
	public StudentModel(){
		super();
	}
	
	//构造函数
	public StudentModel(String stuname, String stunumber, String stusex, Date stubirth,
			String stuaddress, String stuphone,String stumark) {
		super();
		this.stuname = stuname;
		this.stunumber = stunumber;
		this.stusex = stuaddress;
		this.stubirth = stubirth;
		this.stuaddress = stuaddress;
		this.stuphone = stuphone;
		this.stumark = stumark;
	}
	
	/*
	 * 学生信息方法*/
	public int getStuId() {
		return id;
	}
	public void setStuId(int id) {
		this.id = id;
	}
	public String getStunumber() {
		return stunumber;
	}
	public void setStuNo(String stunumber) {
		this.stunumber = stunumber;
	}
	public String getStuName() {
		return stuname;
	}
	public void setStuName(String stuname) {
		this.stuname = stuname;
	}
	public String getSex() {
		return stusex;
	}
	public void setSex(String stusex) {
		this.stusex = stusex;
	}
	public Date getStubirth() {
		return stubirth;
	}
	public void setstuBirth(Date stubirth) {
		this.stubirth = stubirth;
	}
	public String getStuaddress() {
		return stuaddress;
	}
	public void setStuaddress(String stuaddress) {
		this.stuaddress = stuaddress;
	}
	public String getStuPhone() {
		return stuphone;
	}
	public void setStuPhone(String stuphone) {
		this.stuphone = stuphone;
	}
	public String getStuMark() {
		return stumark;
	}
	public void setStuMark(String stumark) {
		this.stumark = stumark;
	}
}
