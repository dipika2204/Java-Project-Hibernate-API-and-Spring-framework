package com.project2.Interface;

import com.project2.Model.User;

public interface userDaoInterface {
	void insert(User user);
	User login(String username, String password);
	User getuserbyid(String username);

}
