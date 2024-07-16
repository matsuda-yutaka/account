package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.account.util.DBConnector;

public class DeleteCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private String sql = "INSERT INTO account_info(delete_flag) VALUES(1)";

	public void cerateUser(String delete_flag) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, delete_flag);

			preparedStatement.execute();

		} catch(Exception e) {
			System.out.println("エラーが発生したためアカウント削除できません。");
		} finally {
			connection.close();
		}
	}
}
