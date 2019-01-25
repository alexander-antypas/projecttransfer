package gr.hua.dit.transfer;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import gr.hua.dit.classes.INTERNAL_USER;
import gr.hua.dit.classes.authorities;
import gr.hua.dit.classes.user;

public class InternalService {
	
//////ADD INTERNAL_USER
	public static String registerNewUserAccount(user user1, INTERNAL_USER user, authorities auth) {
		// create session factory
		SessionFactory factory_Internal_User = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(INTERNAL_USER.class).buildSessionFactory();

		// create session
		Session session = factory_Internal_User.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(user);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		}

		finally {
			factory_Internal_User.close();
		}

		// create session factory
		SessionFactory factory_user = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(user.class)
				.buildSessionFactory();

		// create session
		Session session2 = factory_user.getCurrentSession();

		try {
			// start a transaction
			session2.beginTransaction();

			// save the student object
			session2.save(user1);

			// commit transaction
			session2.getTransaction().commit();
			System.out.println("Done!");

		}

		finally {
			factory_user.close();
		}

		// create session factory
		SessionFactory factory_authorities = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(authorities.class).buildSessionFactory();

		// create session
		Session session3 = factory_authorities.getCurrentSession();

		try {
			// start a transaction
			session3.beginTransaction();

			// save the student object
			session3.save(auth);

			// commit transaction
			session3.getTransaction().commit();
			System.out.println("Done!");

			return "Η ΕΓΓΡΑΦΗ ΟΛΟΚΛΗΡΩΘΗΚΕ";
		}

		finally {
			factory_authorities.close();
		}

	}
/////SEARCH INTERNAL_USER
	public static INTERNAL_USER searchInternal(String id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(INTERNAL_USER.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// query application(s) with user_id

			INTERNAL_USER user = session.get(INTERNAL_USER.class, id);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

			return user;

		} finally {
			factory.close();
		}
	}
/////SHOW INTERNAL_USER_ID
	public static List<INTERNAL_USER> showusers() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(INTERNAL_USER.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// query applications
			@SuppressWarnings("unchecked")
			List<INTERNAL_USER> users = session.createQuery("from INTERNAL_USER").getResultList();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

			return users;

		} finally {
			factory.close();
		}

	}
//////UPDATE INTERNAL_USER
	public static String Update(user user1, INTERNAL_USER user, authorities auth, String id) {
		// create session factory
		SessionFactory factory1 = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(INTERNAL_USER.class).buildSessionFactory();

		// create session
		Session session1 = factory1.getCurrentSession();

		session1.beginTransaction();

		String U1 = "UPDATE INTERNAL_USER SET " + "id = :id, " + "first_name = :first_name, "
				+ "last_name = :last_name, " + "pw = :pw, " + "year_of_birth = :year_of_birth, " + "age = :age, "
				+ "email = :email, " + "employee_type = :employee_type, "
				+ "year_of_recruitment = :year_of_recruitment, " + "department = :department "
				+ "WHERE id = :identity ";

		Query query1 = session1.createQuery(U1);
		query1.setParameter("identity", id);
		query1.setParameter("id", user.getId());
		query1.setParameter("first_name", user.getFirst_name());
		query1.setParameter("last_name", user.getLast_name());
		query1.setParameter("pw", user.getPassword());
		query1.setParameter("year_of_birth", user.getYear_of_birth());
		query1.setParameter("age", user.getAge());
		query1.setParameter("email", user.getEmail());
		query1.setParameter("employee_type", user.getEmployee_type());
		query1.setParameter("year_of_recruitment", user.getYear_of_recruitment());
		query1.setParameter("department", user.getDepartment());
		int result1 = query1.executeUpdate();
		System.out.println("Rows affected: " + result1);
		// commit transaction

		session1.getTransaction().commit();
		System.out.println("Done!");

		factory1.close();

		// create session factory
		SessionFactory factory2 = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(user.class)
				.buildSessionFactory();

		// create session
		Session session2 = factory2.getCurrentSession();

		session2.beginTransaction();

		String U2 = "UPDATE user SET " + "username = :username, " + "password = :password, " + "enabled = :enabled "
				+ "WHERE username = :identity ";

		Query query2 = session2.createQuery(U2);
		query2.setParameter("identity", id);
		query2.setParameter("username", user1.getUsername());
		query2.setParameter("password", user1.getPassword());
		query2.setParameter("enabled", user1.getEnabled());

		int result2 = query2.executeUpdate();
		System.out.println("Rows affected: " + result2);
		// commit transaction

		session2.getTransaction().commit();
		System.out.println("Done!");

		factory2.close();

		// create session factory
		SessionFactory factory3 = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(authorities.class).buildSessionFactory();

		// create session
		Session session3 = factory3.getCurrentSession();

		session3.beginTransaction();

		String U3 = "UPDATE authorities SET " + "username = :username, " + "authority = :authority "
				+ "WHERE username = :identity ";

		Query query3 = session3.createQuery(U3);
		query3.setParameter("identity", id);
		query3.setParameter("username", auth.getId());
		query3.setParameter("authority", auth.getAuthority());

		int result3 = query3.executeUpdate();
		System.out.println("Rows affected: " + result3);
		// commit transaction

		session3.getTransaction().commit();
		System.out.println("Done!");

		factory3.close();
		
		return "ΤΑ ΣΤΟΙΧΕΙΑ ΤΟΥ ΧΡΗΣΤΗ ΕΝΗΜΕΡΩΘΗΚΑΝ";
	}
////DELETE INTERNAL_USER
	public static String delete(String id) {
		
		// create session factory
				SessionFactory factory1 = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(INTERNAL_USER.class).buildSessionFactory();

				// create session
				Session session1 = factory1.getCurrentSession();

				session1.beginTransaction();

				String U1 = "DELETE FROM INTERNAL_USER WHERE id = :identity ";

				Query query1 = session1.createQuery(U1);
				query1.setParameter("identity", id);
				int result1 = query1.executeUpdate();
				System.out.println("Rows affected: " + result1);
				
				// commit transaction

				session1.getTransaction().commit();
				System.out.println("Done!");

				factory1.close();

				// create session factory
				SessionFactory factory2 = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(user.class)
						.buildSessionFactory();

				// create session
				Session session2 = factory2.getCurrentSession();

				session2.beginTransaction();

				String U2 = "DELETE FROM user WHERE username = :identity ";

				Query query2 = session2.createQuery(U2);
				query2.setParameter("identity", id);

				int result2 = query2.executeUpdate();
				System.out.println("Rows affected: " + result2);
				// commit transaction

				session2.getTransaction().commit();
				System.out.println("Done!");

				factory2.close();

				// create session factory
				SessionFactory factory3 = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(authorities.class).buildSessionFactory();

				// create session
				Session session3 = factory3.getCurrentSession();

				session3.beginTransaction();

				String U3 = "DELETE FROM authorities WHERE username = :identity ";

				Query query3 = session3.createQuery(U3);
				query3.setParameter("identity", id);

				int result3 = query3.executeUpdate();
				System.out.println("Rows affected: " + result3);
				// commit transaction

				session3.getTransaction().commit();
				System.out.println("Done!");

				factory3.close();

			return "Ο ΧΡΗΣΤΗΣ ΔΙΑΓΡΑΦΗΚΕ";
	}

}
