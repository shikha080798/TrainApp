package com.hcl.trainapp.dto;

public class UserOtpDto {
	private Long userId;
	private Long otp;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}

}
