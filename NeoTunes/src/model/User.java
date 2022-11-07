package model;

import java.sql.Date; 

public abstract class User {

	private String nickName;
	private String id;
	private Date linkingDate;

	public User(String nickName, String id, Date linkingDate) {
		super();
		this.nickName = nickName;
		this.id = id;
		this.linkingDate = linkingDate;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLinkingDate() {
		return linkingDate;
	}

	public void setLinkingDate(Date linkingDate) {
		this.linkingDate = linkingDate;
	}

	@Override
	public String toString() {
		return "\nUser \nNickName:" + nickName + "\nId Number:" + id + "\nLinking Date:" + linkingDate;
	}

}
