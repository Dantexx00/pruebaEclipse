import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.hibernateProject.dto.UserAddress;
import co.edu.udea.hibernateProject.dto.UserDetails;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDetails userDetails = new UserDetails();
		userDetails.setUserName("Usuario3");
		userDetails.setJoinedDate(new Date());
		userDetails.setDescription("description");
		
		UserAddress address = new UserAddress();
		address.setCity("city1");
		address.setPinCode("code1");
		address.setState("state1");
		address.setStreet("street1");
		userDetails.setAddress(address);
		
		Configuration config = new Configuration();
		config.configure();
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		
		userDetails = null;
		/*
		session = sessionFactory.openSession();
		session.beginTransaction();
		userDetails = (UserDetails)session.get(UserDetails.class, 5);
		System.out.println("User name is: "+userDetails.getAddress().getCity());
		session.close();
		*/
	}

}
