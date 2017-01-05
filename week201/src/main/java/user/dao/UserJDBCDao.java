package user.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.model.User;

public class UserJDBCDao implements UserDao {
	
	Connection conn;
	
	public void setConnection(Connection connection) {
		this.conn = connection;
	}
	
	
	public User find(String email) {
		User user = null;
		String query = "SELECT * FROM user WHERE email=\"" + email +"\"";

		try {
			ResultSet rs = conn.createStatement().executeQuery( query );
	
			user = new User();
			user.setPrenom(rs.getString(3));
			user.setNom(rs.getString(2));
			user.setMail(rs.getString(1));
			user.setMotDePasse(rs.getString(4));

			rs.close();
		} catch ( SQLException e ) {
			throw new Error("Unable to find User " + email, e);
		}
		
		return user;
	}


	public void delete(String email) {
		String query = "DELETE FROM user WHERE email=\"" + email +"\"";
		
		try {
			conn.createStatement().executeUpdate(query);
		} catch(SQLException e) {
			throw new Error("Unable to delete User " + email, e);
		}
	}

	public void create(User user) {
		String email =user.getMail();
		String nom =user.getNom();
		String prenom =user.getPrenom();
		String motdepasse =user.getMotDePasse() ;

		String query = "INSERT INTO user VALUES (\"" + email + "\",\"" + nom + "\",\"" + prenom + "\",\"" + motdepasse + "\")";
		try {
			conn.createStatement().executeUpdate(query);
		} catch(SQLException e) {
			throw new Error("Unable to insert User " + user, e);
		}
	}

	public void update(User user) {
		String userEmail =user.getMail();
		String userNom =user.getNom();
		String userPrenom =user.getPrenom();
		String userMotdepasse =user.getMotDePasse() ;
		String query = "UPDATE user SET lastname=\"" + userNom + "\", firstname=\"" + userPrenom + "\", pwd=\"" + userMotdepasse + "\" WHERE email=\"" + userEmail +"\"";


		try {
			conn.createStatement().executeUpdate(query);
		} catch(SQLException e) {
			throw new Error("Unable to insert User " + user, e);
		}
	}


	public boolean checkPassword(String email, String password) {
		String query = "SELECT * from user WHERE email=\"" + email +"\"" +"and pwd=\"" + password +"\"";
		
		try {
			ResultSet rs = conn.createStatement().executeQuery(query);
			boolean exists = rs.next();
			rs.close();
			return exists;
		} catch(SQLException e) {
			throw new Error("Unable to identified User " + email, e);
		}
	}
}
