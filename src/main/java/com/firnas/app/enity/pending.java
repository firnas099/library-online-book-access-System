package com.firnas.app.enity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class pending {

	@Id
	@GeneratedValue
	private int id;
	private String fname;
	private String NIC;
	private String DOB;
	private String pro ;
	private String address ;
	private String nat ;
	private String gender; 
	private String email ;
	private String pass ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNat() {
		return nat;
	}
	public void setNat(String nat) {
		this.nat = nat;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "pending [id=" + id + ", fname=" + fname + ", NIC=" + NIC + ", DOB=" + DOB + ", pro=" + pro
				+ ", address=" + address + ", nat=" + nat + ", gender=" + gender + ", email=" + email + ", pass=" + pass
				+ "]";
	}
	
	
	
}
