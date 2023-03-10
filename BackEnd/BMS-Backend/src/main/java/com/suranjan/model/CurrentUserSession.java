package com.suranjan.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//import lombok.Data;

@Entity
//@Data
public class CurrentUserSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer userId;
	
	@NotNull
	private String userName;
	
	private LocalDateTime localDateTime;
	
	private String uuid;
	
	public CurrentUserSession() {
		// TODO Auto-generated constructor stub
	}

	public CurrentUserSession( Integer userId, @NotNull String userName, LocalDateTime localDateTime,
			String uuid) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.localDateTime = localDateTime;
		this.uuid = uuid;
	}

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "CurrentUserSession [userId=" + userId + ", userName=" + userName + ", localDateTime=" + localDateTime
				+ ", uuid=" + uuid + "]";
	}

	
	

}
