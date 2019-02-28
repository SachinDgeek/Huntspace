package com.yammizzaa.fooddelivery.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.yammizzaa.fooddelivery.model.Driver;
import com.yammizzaa.fooddelivery.model.OrederFood;

//@Repository indicates that the class is DAO where methods perform operations over database
@Repository
@Service
public class DriverDAOImpl implements DriverDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	// method to get session
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session session;
	Transaction tx;

	// saving the driver details into database
	public void adddriver(Driver driver) {
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
        driver.setOrderstatus("Available");
		session.persist(driver);
		tx.commit();
		session.close();
	}

	// method to get driver list from database
	@SuppressWarnings("unchecked")
	public List<Driver> driverlist() {
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Driver> driverList = session.createCriteria(Driver.class).list();
		tx.commit();
		session.close();
		return driverList;
	}

	// method to check whether the driver credentials are correct or not
	public String checkDriverCredentials(Driver driver) {
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select 1 from Driver where email='" + driver.getEmail()
				+ "' and password = '" + driver.getPassword() + "'");
		if (query.uniqueResult() != null) {
			return "success";
		} else {
			return "failure";
		}
	}

	public Driver getdriverbyemail(String email) {
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria crit = session.createCriteria(Driver.class);
			crit.add(Restrictions.eq("email", email));
			@SuppressWarnings("unchecked")
			List<Driver> list = crit.list();
			System.err.println("ManageDAOImpl.CustomerDetails()-------------->" + list);
			return list.get(0);
		} catch (Exception e) {
			System.err.println("ManageDAOImpl.CustomerDetails()---------------> from catch :" + e);
			return null;
		} finally {
			session.close();
		}
	}

	public String deletedriver(Integer id) {
		try {

			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			final String HQL_QRY_FOR_DELETE = "delete from Driver where id=:id";

			Query query = session.createQuery(HQL_QRY_FOR_DELETE);
			query.setParameter("id", id);

			query.executeUpdate();

			tx.commit();

			return "ok";
		} catch (Exception e) {

			System.err.println("Exception : " + e.getMessage());
			tx.rollback();
		}
		return "ok";

		
	}

	public List<Driver> Availabledrivers() {
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		SQLQuery query=session.createSQLQuery("select * from Driver where Orderstatus='Available'");
		List<Driver> driverList = query.list();
		tx.commit();
		session.close();
		return driverList;
	}

	public List<OrederFood> assigneddriverget(long phone) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.createQuery("from OrederFood where phone='" + phone + "'");
			List<OrederFood> order = (List<OrederFood>) query.list();

			tx.commit();
			return order;
		} catch (Exception e) {
			tx.rollback();
			System.err.println(e);
			return null;
		} finally {
			session.close();
		}
	}
		
	}
	
	  

