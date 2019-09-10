package org.simple.domain;

public class BbsVO {
	
	private int bno;
	private String id;
	private String name;
	private String adress;
	private String idNum;
	private int gender;
//	private byte[] picture;
	
	private FileVO fileVo;
	private EduVO eduVo;
	
	

//	public byte[] getPicture() {
//		return picture;
//	}
//
//	public void setPicture(byte[] picture) {
//		this.picture = picture;
//	}

	public EduVO getEduVo() {
		return eduVo;
	}

	public void setEduVo(EduVO eduVo) {
		this.eduVo = eduVo;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public int getBno() {
		return bno;
	}
	
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public FileVO getFileVo() {
		return fileVo;
	}
	public void setFileVo(FileVO fileVo) {
		this.fileVo = fileVo;
	}
	
	
	

}
