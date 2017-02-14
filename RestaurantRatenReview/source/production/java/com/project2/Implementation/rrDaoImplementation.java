package com.project2.Implementation;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.project2.Interface.rrDaoInterface;
import com.project2.Model.RateReview;

public class rrDaoImplementation extends HibernateDaoSupport implements rrDaoInterface {

	@Override
	public List<?> gettAllRatenReview() {
		// TODO Auto-generated method stub
		List<?> list = null;
		List<?> sum = null;
		RateReview re = new RateReview();
		try {
			list = (List<?>) getHibernateTemplate().find("from RateReview ");
			//re = (RateReview) list.get(0);

		} catch (EmptyResultDataAccessException e) {
			System.out.println("Error" + e);
			
		}
		return list;

	}

	@Transactional(readOnly = false)
	@Override
	public void insert(RateReview ratereview) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(ratereview);
	}

}
