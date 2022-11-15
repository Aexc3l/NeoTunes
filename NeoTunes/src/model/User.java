package model;

import java.time.LocalDate;  

public abstract class User {

	private String nickName;
	private String id;
	private LocalDate linkingDate;

	public User(String nickName, String id, LocalDate linkingDate) {
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


	public LocalDate getLinkingDate() {
		return linkingDate;
	}

	public void setLinkingDate(LocalDate linkingDate) {
		this.linkingDate = linkingDate;
	}


	@Override
	public String toString() {
		return "\nUser \nNickName:" + nickName + "\nId Number:" + id + "\nLinking Date:" + linkingDate;
	}

}
