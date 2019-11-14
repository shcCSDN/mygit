package com.easytop.pojo;
import java.io.Serializable;
public class User implements Serializable {
	private Integer uid;
	private String userName;
	private String passWord;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", passWord=" + passWord + "]";
	}
}
