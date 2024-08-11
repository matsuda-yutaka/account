package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.UpdatePasswordCompleteDAO;
import com.diworksdev.account.dto.UpdateCompleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatePasswordCompleteAction extends ActionSupport implements SessionAware {

	private String id;
	private String password;
	private String update_time;
	private List<UpdateCompleteDTO> updateCompleteDTOList = new ArrayList<UpdateCompleteDTO>();
	private Map<String, Object> session;
	private UpdatePasswordCompleteDAO updatePasswordCompleteDAO = new UpdatePasswordCompleteDAO();

	public String execute() throws SQLException {

		String result = ERROR;

		UpdatePasswordCompleteDAO dao=new UpdatePasswordCompleteDAO();
		updateCompleteDTOList=dao.select(id);

		try {

			if(id.equals(updateCompleteDTOList.get(0).getId())){

				int rs =dao.Update(id,
						session.get("password").toString(),
						update_time);
				result = SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}