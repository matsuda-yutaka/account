package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.account.dto.AccountListDTO;
import com.diworksdev.account.util.ChangeFromStringToDate;
import com.diworksdev.account.util.DBConnector;

public class AccountListDAO {

	List<AccountListDTO> accountListDTOList = new ArrayList<AccountListDTO>();

	public List<AccountListDTO> select() {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ChangeFromStringToDate changeFromStringToDate = new ChangeFromStringToDate();
		String sql = "select * from account_info";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				AccountListDTO dto=new AccountListDTO();
				dto.setId(rs.getString("id"));
				dto.setFamily_name(rs.getString("family_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setFamily_name_kana(rs.getString("family_name_kana"));
				dto.setLast_name_kana(rs.getString("last_name_kana"));
				dto.setMail(rs.getString("mail"));
				dto.setGender(rs.getString("gender"));
				dto.setAuthority(rs.getString("authority"));
				dto.setDelete_flag(rs.getString("delete_flag"));
				dto.setRegistered_time(rs.getString("registered_time"));
				dto.setUpdate_time(rs.getString("update_time"));

				accountListDTOList.add(dto);
			}

		} catch (SQLException e) {
				e.printStackTrace();
		}
		try {
			con.close();

		} catch (SQLException e) {
				e.printStackTrace();
		}
		return accountListDTOList;
	}
}