package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.account.dto.DeleteCompleteDTO;
import com.diworksdev.account.util.DBConnector;

public class DeleteCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public List<DeleteCompleteDTO> deleteCompleteDTOList = new ArrayList<DeleteCompleteDTO>();

	public List<DeleteCompleteDTO> select(String id, String delete_flag) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="select * from account_info where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				DeleteCompleteDTO dto = new DeleteCompleteDTO();
				dto.setId(rs.getString("id"));
				dto.setDelete_flag(rs.getString("delete_flag"));
				deleteCompleteDTOList.add(dto);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteCompleteDTOList;
	}

	//メソッドの名前をDeleteCompleteから実際の処理「Update」に変えた
	public int Update(String id) throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "UPDATE FROM account_info set delete_flag=1 where id=?";
		PreparedStatement preparedStatement;
		int rs =0;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return rs;
	}
}