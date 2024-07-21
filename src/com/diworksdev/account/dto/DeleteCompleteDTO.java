package com.diworksdev.account.dto;

public class DeleteCompleteDTO {

	private String id;
	private String delete_flag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
}
