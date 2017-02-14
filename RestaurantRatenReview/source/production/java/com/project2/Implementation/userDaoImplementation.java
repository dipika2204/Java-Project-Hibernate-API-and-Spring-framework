package com.project2.Implementation;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.project2.Interface.userDaoInterface;
import com.project2.Model.User;



public class userDaoImplementation extends HibernateDaoSupport implements userDaoInterface{

	@Transactional (readOnly=false)
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
	getHibernateTemplate().save(user);
		
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User loginUser = null;
		List<?> list=null;
		
		try {
			list = (List<?>) getHibernateTemplate().find("from User where username=? and password=?",username,password);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Error" + e);
		}
		loginUser=(User)list.get(0);
		return loginUser;
}

	@Override
	public User getuserbyid(String username) {
		// TODO Auto-generated method stub
		User loginUser = null;
		List<?> list=null;
		
		try {
		 
			list = (List<?>) getHibernateTemplate().find("from User where username= ?",username);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Error" + e);
		}
		loginUser=(User)list.get(0);
		return loginUser;
		
	}

}
