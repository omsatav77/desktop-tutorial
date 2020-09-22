package dao;

import java.util.ArrayList;

public class Todotask {
private	String email;
private	String desc1;
private String status1;
private String title1;
private int id;
public static ArrayList<Todotask>todolist;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesc1() {
		return desc1;
	}
	
//	public Todotask(String email, String desc1, String status1, String title1, int id) {
//
//		this.email = email;
//		this.desc1 = desc1;
//		this.status1 = status1;
//		this.title1 = title1;
//		this.id = id;
//	
//	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	public String getTitle1() {
		return title1;
	}
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
