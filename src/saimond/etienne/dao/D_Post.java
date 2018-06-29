package saimond.etienne.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import saimond.etienne.models.M_Post;

import java.sql.DriverManager;

public class D_Post extends D_Context {

	public static boolean addPost(String content, String urlImg) throws SQLException {

		try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {

			String strSql 	= "INSERT INTO T_Post(PostContent, urlImgPost) " 
							+ "VALUES (?, ?);";

			PreparedStatement statement = connection.prepareStatement(strSql);
			statement.setString(1, content);
			statement.setString(2, urlImg);
			
			int resultSet = statement.executeUpdate();

			if (resultSet > 0) {
				return true;
				
			} else {
				return false;
			}
		}
	}
	
	public static M_Post getPost(int idPost) {
		try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {

			String strSql 	= "SELECT *" 
							+ "FROM T_Post;"
							+ "WHERE IdPlaylist = ?";

			PreparedStatement statement = connection.prepareStatement(strSql);
			statement.setInt(1, idPost);
			
			ResultSet resultSet = statement.executeQuery(strSql);
			if (resultSet.next()) {
				return new 	M_Post(resultSet.getInt("IdPost"), 
							resultSet.getString("PostContent"), 
							resultSet.getString("urlImgPost"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<M_Post> getAllPost() {
		
		ArrayList<M_Post> postList = new ArrayList<M_Post>();
		
		try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
			
			String strSql 	= " SELECT * " 
							+ " FROM T_Post;";
	
			PreparedStatement statement = connection.prepareStatement(strSql);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
			    do {
			    	M_Post post = new 	M_Post(resultSet.getInt("IdPost"), 
			    						resultSet.getString("PostContent"), 
			    						resultSet.getString("urlImgPost"));
					postList.add(post);
			    } while(resultSet.next());
			} else {
				postList.add(new M_Post(0,"No Post Yet", "http://qnimate.com/wp-content/uploads/2014/03/images2.jpg"));
			}
			
			return postList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return null;
	}
}