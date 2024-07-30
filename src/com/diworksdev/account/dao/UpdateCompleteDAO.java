package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.diworksdev.account.dto.UpdateCompleteDTO;
import com.diworksdev.account.util.DBConnector;

public class UpdateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

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
				updateCompleteDTOList.add(dto);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return updateCompleteDTOList;
	}

	private String sql = "UPDATE account_info set family_name=? last_name=? family_name_kana=? last_name_kana=? mail=? password=? gender=? postal_code=? prefecture=? address_1=? address_2=? authority=? where id=?";

	public int Update(String id, String family_name, String last_name, String family_name_kana, String last_name_kana, String mail, String password, String gender, String postal_code, String prefecture, String address_1, String address_2, String authority) throws SQLException {

		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String encodeedPassword = bcpe.encode(password);
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		PreparedStatement preparedStatement;
		int rs =0;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, family_name);
			preparedStatement.setString(3, last_name);
			preparedStatement.setString(4, family_name_kana);
			preparedStatement.setString(5, last_name_kana);
			preparedStatement.setString(6, mail);
			preparedStatement.setString(7, encodeedPassword);
			preparedStatement.setString(8, gender);
			preparedStatement.setString(9, postal_code);
			preparedStatement.setString(10, prefecture);
			preparedStatement.setString(11, address_1);
			preparedStatement.setString(12, address_2);
			preparedStatement.setString(13, authority);
			//preparedStatement.setString(13, dateUtil.getDate());

			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return rs;
	}
}