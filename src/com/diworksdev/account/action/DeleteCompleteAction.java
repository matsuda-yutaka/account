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

	public String execute() throws SQLException {
		String result = ERROR;

		DeleteCompleteDAO dao=new DeleteCompleteDAO();

		System.out.println(id);
		deleteCompleteDTOList=dao.select(id, delete_flag);

		try {
			if(id.equals(deleteCompleteDTOList.get(0).getId())){

			System.out.println(id);
			int rs = dao.Update(id);

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