package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.account.dto.UpdateCompleteDTO;
import com.diworksdev.account.util.DBConnector;
import com.diworksdev.account.util.DateUtil;

public class UpdateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	public List<UpdateCompleteDTO> updateCompleteDTOList = new ArrayList<UpdateCompleteDTO>();

	public List<UpdateCompleteDTO> select(String id) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="select * from account_info where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				UpdateCompleteDTO dto = new UpdateCompleteDTO();
				dto.setId(rs.getString("id"));
				dto.setFamily_name(rs.getString("family_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setFamily_name_kana(rs.getString("family_name_kana"));
				dto.setLast_name_kana(rs.getString("last_name_kana"));
				dto.setMail(rs.getString("mail"));
				dto.setGender(rs.getString("gender"));
				dto.setPostal_code(rs.getString("postal_code"));
				dto.setPrefecture(rs.getString("prefecture"));
				dto.setAddress_1(rs.getString("address_1"));
				dto.setAddress_2(rs.getString("address_2"));
				dto.setAuthority(rs.getString("authority"));
				dto.setUpdate_time(rs.getString("update_time"));
				updateCompleteDTOList.add(dto);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return updateCompleteDTOList;
	}

	public int Update(String id, String family_name, String last_name, String family_name_kana, String last_name_kana, String mail, String gender, String postal_code, String prefecture, String address_1, String address_2, String authority, String update_time) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "UPDATE account_info set family_name=?, last_name=?, family_name_kana=?, last_name_kana=?, mail=?, gender=?, postal_code=?, prefecture=?, address_1=?, address_2=?, authority=?, update_time=? where id=?";
		PreparedStatement preparedStatement;
		int rs =0;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, family_name);
			preparedStatement.setString(2, last_name);
			preparedStatement.setString(3, family_name_kana);
			preparedStatement.setString(4, last_name_kana);
			preparedStatement.setString(5, mail);
			preparedStatement.setString(6, gender);
			preparedStatement.setString(7, postal_code);
			preparedStatement.setString(8, prefecture);
			preparedStatement.setString(9, address_1);
			preparedStatement.setString(10, address_2);
			preparedStatement.setString(11, authority);
			preparedStatement.setString(12, dateUtil.getDate());
			preparedStatement.setString(13, id);

			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return rs;
	}
}