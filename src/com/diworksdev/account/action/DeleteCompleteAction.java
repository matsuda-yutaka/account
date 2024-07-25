package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.DeleteCompleteDAO;
import com.diworksdev.account.dto.DeleteCompleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCompleteAction extends ActionSupport implements SessionAware {

	private String id;
	private String delete_flag;
	private List<DeleteCompleteDTO> deleteCompleteDTOList = new ArrayList<DeleteCompleteDTO>();
	private Map<String, Object> session;
	private DeleteCompleteDAO deleteCompleteDAO = new DeleteCompleteDAO();

	public String executeupdate() throws SQLException {
		String result = ERROR;

		DeleteCompleteDAO dao=new DeleteCompleteDAO();

		deleteCompleteDTOList=dao.select(id, delete_flag);

		System.out.println(id);
		System.out.println(deleteCompleteDTOList.get(0).getId());
		if(id.equals(deleteCompleteDTOList.get(0).getId())){

			int rs = Update(id);
			deleteCompleteDAO.Update = executeupdate();


			result = SUCCESS;

		} else {

			result = ERROR;
		}
		return result;
	}

	private DeleteCompleteDAO Update() throws SQLException {
		DeleteCompleteDAO deleteCompleteDAO = new DeleteCompleteDAO();
		String id = session.get("id").toString();
		return deleteCompleteDAO;
	}

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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}