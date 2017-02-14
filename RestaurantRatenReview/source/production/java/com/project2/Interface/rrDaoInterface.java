package com.project2.Interface;

import java.util.List;

import com.project2.Model.RateReview;
import com.project2.Model.Rest;

public interface rrDaoInterface {
	List<?> gettAllRatenReview();
	void insert(RateReview ratereview);
}
