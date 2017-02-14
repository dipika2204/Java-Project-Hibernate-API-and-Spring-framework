package com.project2.Model;

public class RateReview {
private int rate_reviewId;
private int user_id;
private int rest_id;
private int rate;
private String review;
/**
 * @return the rate_reviewId
 */
public int getRate_reviewId() {
	return rate_reviewId;
}
/**
 * @param rate_reviewId the rate_reviewId to set
 */
public void setRate_reviewId(int rate_reviewId) {
	this.rate_reviewId = rate_reviewId;
}
/**
 * @return the user_id
 */
public int getUser_id() {
	return user_id;
}
/**
 * @param user_id the user_id to set
 */
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
/**
 * @return the rest_id
 */
public int getRest_id() {
	return rest_id;
}
/**
 * @param rest_id the rest_id to set
 */
public void setRest_id(int rest_id) {
	this.rest_id = rest_id;
}
/**
 * @return the rate
 */
public int getRate() {
	return rate;
}
/**
 * @param rate the rate to set
 */
public void setRate(int rate) {
	this.rate = rate;
}
/**
 * @return the review
 */
public String getReview() {
	return review;
}
/**
 * @param review the review to set
 */
public void setReview(String review) {
	this.review = review;
}

}
