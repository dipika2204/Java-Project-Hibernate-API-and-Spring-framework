package com.project2.Implementation;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.project2.Interface.restDaoInterface;
import com.project2.Model.Rest;
import com.project2.Model.User;

public class restDaoImplementation extends HibernateDaoSupport implements restDaoInterface {

	@Transactional(readOnly = false)
	@Override
	public List<?> getAllRest() {
		// TODO Auto-generated method stub
		List<?> list = null;
		try {
			list = (List<?>) getHibernateTemplate().find("from Rest");
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Error" + e);
		}
		return list;
	}

	@Transactional(readOnly = false)
	@Override
	public void insert(Rest rest) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(rest);
	}

	@Override
	public Rest getrestbyid(int restaurant_id) {
		// TODO Auto-generated method stub
		Rest countnrate = null;
		List<?> list = null;

		try {

			list = (List<?>) getHibernateTemplate().find("from Rest where restId=? ", restaurant_id);

		} catch (EmptyResultDataAccessException e) {
			System.out.println("Error" + e);
		}
		countnrate = (Rest) list.get(0);
		return countnrate;

	}

	@Transactional(readOnly = false)
	@Override
	public void updateRest_info(Rest rest) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(rest);
	}

}
