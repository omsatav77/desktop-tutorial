package dao;

import java.util.ArrayList;
import java.util.Date;

public class empdao {
	public static ArrayList<empdao>userlist;
	private String fname;
	private String lname;
	
	private String email1;
	private String gendar;
	
	private String pass;
	private String DateOfBirth;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "empdao [fname=" + fname + ", lname=" + lname + ", email1=" + email1 + ", gendar=" + gendar + ", pass="
				+ pass + ", DateOfBirth=" + DateOfBirth + ", status=" + status + "]";
	}
	public String getFname() {
		return fname;
	}
	
	
	

	public empdao() {
		// TODO Auto-generated constructor stub
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getGendar() {
		return gendar;
	}
	public void setGendar(String gendar) {
		this.gendar = gendar;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	} 

}
