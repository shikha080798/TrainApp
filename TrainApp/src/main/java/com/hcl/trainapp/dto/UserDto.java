package com.hcl.trainapp.dto;

import javax.validation.constraints.NotNull;

public class UserDto {
	@NotNull
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
        this.userName = userName;
    }
}