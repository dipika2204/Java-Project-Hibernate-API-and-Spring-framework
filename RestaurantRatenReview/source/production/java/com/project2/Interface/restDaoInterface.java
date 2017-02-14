package com.project2.Interface;

import java.util.List;

import com.project2.Model.Rest;
import com.project2.Model.User;

public interface restDaoInterface {
	List <?> getAllRest();
	void insert(Rest rest);
	Rest getrestbyid(int restaurant_id);
	void updateRest_info(Rest rest);
}
