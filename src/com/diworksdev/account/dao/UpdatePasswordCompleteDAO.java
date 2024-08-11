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
import com.diworksdev.account.util.DateUtil;

public class UpdatePasswordCompleteDAO {
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
				dto.setAuthority(rs.getString("password"));
				dto.setUpdate_time(rs.getString("update_time"));
				updateCompleteDTOList.add(dto);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return updateCompleteDTOList;
	}

	public int Update(String id, String password, String update_time) throws SQLException {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String encodeedPassword = bcpe.encode(password);
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "UPDATE account_info set password=?, update_time=? where id=?";
		PreparedStatement preparedStatement;
		int rs =0;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, encodeedPassword);
			preparedStatement.setString(2, dateUtil.getDate());
			preparedStatement.setString(3, id);

			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return rs;
	}
}