package com.Gowfy.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Gowfy.model.User;

@Repository
@Transactional

public class UserDaoimpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void UserDaoImpl() {
		System.out.println("User Dao is created");
	}
	
	public void registration(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
	}

	public boolean isEmailUnique(String email) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=?");
		query.setString(0, email);
		User user=(User) query.uniqueResult();
		if(user!=null) {
			return false;
		}else {
				return true;
		}
	}

	//dao will get user object from middleware
	public User login(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=? and password=?");
		query.setString(0, user.getEmail());
		query.setString(1, user.getPassword());
		return (User)query.uniqueResult();		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(user);//update user_s190035 set password=?,fn=?,ln=?pn=?,online_stauts=?,role=? where email=?
		//, online_status=? where email=?
	}

	public User getUser(String email) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);		
		return user;
	}

}


