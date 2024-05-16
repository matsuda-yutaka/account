package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.account.util.DBConnector;
import com.diworksdev.account.util.DateUtil;

public class UserCreateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO account_info(family_name, last_name, family_name_kana, last_name_kana, mail, password, gender, postal_code, prefecture, address_1, address_2, authority, registered_time) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public void cerateUser(String family_name, String last_name, String family_name_kana, String last_name_kana, String mail, String password, String gender, String postal_code, String prefecture, String address_1, String address_2, String authority) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, family_name);
			preparedStatement.setString(2, last_name);
			preparedStatement.setString(3, family_name_kana);
			preparedStatement.setString(4, last_name_kana);
			preparedStatement.setString(5, mail);
			preparedStatement.setString(6, password);
			preparedStatement.setString(7, gender);
			preparedStatement.setString(8, postal_code);
			preparedStatement.setString(9, prefecture);
			preparedStatement.setString(10, address_1);
			preparedStatement.setString(11, address_2);
			preparedStatement.setString(12, authority);
			preparedStatement.setString(13, dateUtil.getDate());

			preparedStatement.execute();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
