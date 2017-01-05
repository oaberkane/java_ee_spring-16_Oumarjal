package user.dao;

import user.controller.model.User;

public interface UserDao {

	public User find(String email);
	public void delete(String email);
	public void create(User user);
	public void update(User user);

	public boolean checkPassword(String email, String password);
	
}
