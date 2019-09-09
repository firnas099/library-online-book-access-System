package com.firnas.app.enity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class boockEntity {

	@Id
	@GeneratedValue
	private int id;
	private String Bname;
	private String Auther;
	private String ISBN;
	private String Year;
	private String Edition;
	private String price;
	private String Content;
	private String ke;
	private String Typ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getAuther() {
		return Auther;
	}
	public void setAuther(String auther) {
		Auther = auther;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getEdition() {
		return Edition;
	}
	public void setEdition(String edition) {
		Edition = edition;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getKe() {
		return ke;
	}
	public void setKe(String ke) {
		this.ke = ke;
	}
	public String getTyp() {
		return Typ;
	}
	public void setTyp(String typ) {
		Typ = typ;
	}
	@Override
	public String toString() {
		return "boockEntity [id=" + id + ", Bname=" + Bname + ", Auther=" + Auther + ", ISBN=" + ISBN + ", Year=" + Year
				+ ", Edition=" + Edition + ", price=" + price + ", Content=" + Content + ", ke=" + ke + ", Typ=" + Typ
				+ "]";
	}
	
	
	
	
	
}
