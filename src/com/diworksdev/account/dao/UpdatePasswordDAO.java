package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.account.dto.UpdatePasswordDTO;
import com.diworksdev.account.util.DBConnector;

public class UpdatePasswordDAO {

	public String id;

	public List<UpdatePasswordDTO> updatePasswordList = new ArrayList<UpdatePasswordDTO>();

	public List<UpdatePasswordDTO> select(String id) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from account_info where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UpdatePasswordDTO dto=new UpdatePasswordDTO();
				dto.setId(rs.getString("id"));
				updatePasswordList.add(dto);
			}

			if(updatePasswordList.size()<=0){
				UpdatePasswordDTO dto=new UpdatePasswordDTO();
				dto.setId("該当なし");
				updatePasswordList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
			return updatePasswordList;
		}
	}