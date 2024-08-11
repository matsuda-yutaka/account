package com.diworksdev.account.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.UpdatePasswordDAO;
import com.diworksdev.account.dto.UpdatePasswordDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatePasswordAction extends ActionSupport implements SessionAware{
	private String id;
	private List<UpdatePasswordDTO> updatePasswordList = new ArrayList<UpdatePasswordDTO>();
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		UpdatePasswordDAO dao=new UpdatePasswordDAO();

		updatePasswordList=dao.select(id);

		if(this.id.equals(updatePasswordList.get(0).getId())){

			session.put("updatePasswordList", updatePasswordList);

			result = SUCCESS;

		} else {

			session.put("updatePasswordList", updatePasswordList);

			result = ERROR;
		}
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session ;
	}
}