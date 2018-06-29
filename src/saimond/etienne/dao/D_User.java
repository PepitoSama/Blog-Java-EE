package saimond.etienne.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import saimond.etienne.models.M_User;

public class D_User extends D_Context {

	public static M_User isValidLogin(String login, String password) {
		
		String strSql 	= 	"SELECT * FROM T_Users WHERE LoginUser = ? "
						+ 	"AND PasswordUser = ?";
		String strAdmin = 	"SELECT t_users.iduser FROM public.t_admins, public.t_users WHERE upper(t_users.loginuser) = upper(?) AND t_admins.iduseradmin = t_users.iduser;";
		M_User user = null;
		password = D_Context.hash(password);
		
		try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
			
			// If strSql is declared like this, DB is vulnerable to SQL INJECTION
			// String strSql = "SELECT * FROM T_Users WHERE login='" + login + "' AND
			// password='" + password + "'";
			
			try (PreparedStatement checkUser = connection.prepareStatement(strSql)) {
				checkUser.setString(1, login);
				checkUser.setString(2, password);
				try (ResultSet resultUser = checkUser.executeQuery()) {
					if (resultUser.next()) {
						System.out.println("Succes");
						user = new M_User();
						user.setIdUser(resultUser.getInt(		"IdUser"));
						user.setLogin(resultUser.getString(		"LoginUser"));
						user.setIdUser(resultUser.getInt(		"ConnectionNumber"));
						user.setName(resultUser.getString(		"Name"));
						user.setLastName(resultUser.getString(	"LastName"));
					} else {
						System.out.println("Echec ");
						return null;
					}
				}
			}
			
			if (user != null ) {
				try (PreparedStatement checkAdmin = connection.prepareStatement(strAdmin)){
					checkAdmin.setString(1, login);
					try (ResultSet resultAdmin = checkAdmin.executeQuery()) {
						if (resultAdmin.next()) {
							user.setAdmin(true);
						}
					} 
				}
			}

		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
		
		return user;
	}

	public static boolean setInfo(String login, String password, String name, String lastname) throws SQLException {

		try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
			
			String strSql = "INSERT INTO T_Users(loginuser,passworduser ,name, lastname) " + 
					"VALUES (?, ?, ?, ?);";
			
			PreparedStatement statement = connection.prepareStatement(strSql);
			statement.setString(	1, login);
			statement.setString(	2, password);
			statement.setString(	3, name);
			statement.setString(	4, lastname);
			
			int resultSet = statement.executeUpdate();
			System.out.println("result set : " + statement.toString());
			if (resultSet > 0) {
				System.out.println("Success");
				return true;
				
			} else {
				System.out.println("Fail ");
				return false;
			}
		}
	}
	
	//@SuppressWarnings
	public static boolean checkPass(String password, String rePassword) {
		
		if (password.length() >= 8 && password == rePassword) {
			return true;
		}
		return false;
	}
}
