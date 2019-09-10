package org.simple.domain;

import java.util.Date;

public class EduVO {
	
	private int eno;
	private String sName;
	private String major;
	private String startYear;
	private String startMonth;
	private String startDay;
	private String endYear;
	private String endMonth;
	private String endDay;
	private String division;
	private Date regDate;
	private Date startDate;
	private Date endDate;

	private int bno;

	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public int getEno() {
		return eno;
	}


	public void setEno(int eno) {
		this.eno = eno;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getStartYear() {
		return startYear;
	}


	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}


	public String getStartMonth() {
		return startMonth;
	}


	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}


	public String getStartDay() {
		return startDay;
	}


	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}


	public String getEndYear() {
		return endYear;
	}


	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}


	public String getEndMonth() {
		return endMonth;
	}


	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}


	public String getEndDay() {
		return endDay;
	}


	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}


	public String getDivision() {
		return division;
	}


	public void setDivision(String division) {
		this.division = division;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}
	
	
	
	
}
