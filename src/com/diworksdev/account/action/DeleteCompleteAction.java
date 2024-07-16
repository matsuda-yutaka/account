package com.diworksdev.account.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.DeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCompleteAction extends ActionSupport implements SessionAware {

	private String delete_flag;
	public Map<String, Object> session;
	private String errorMessage;
	private DeleteCompleteDAO deleteCompleteDAO = new DeleteCompleteDAO();

	public String execute() {

		String result = SUCCESS;
		try {
			deleteCompleteDAO.cerateUser(session.get("delete_flag").toString());
			result = SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result = ERROR;
		}

		return result;
	}

	public String getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}