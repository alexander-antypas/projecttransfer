package gr.hua.dit.transfer;

import java.util.List;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import gr.hua.dit.classes.POSITIONS;

public class DBPositions {

	public static List<Check_Application> hasDep(String starts) {// episterfei list ma8htwn pou exoun dhlwsei to analogo
																	// tmhma

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Check_Application.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			String S = "FROM Check_Application C WHERE C.is_Approved = 1 AND C.check_id LIKE :starts ";// kanei
																												// query

			Query query = session.createQuery(S);
			query.setParameter("starts", starts+"%");// bazei parametro
			@SuppressWarnings("unchecked")
			List<Check_Application> usersIDDEP = query.getResultList();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

			return usersIDDEP;

		} finally {
			factory.close();
		}
	}

	public static List<Check_Application> showAprovedStudents() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Check_Application.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// query applications
			@SuppressWarnings("unchecked")
			List<Check_Application> usersID = session
					.createQuery(" FROM Check_Application C WHERE C.is_Approved = 1 ORDER BY C.points DESC ")
					.getResultList();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

			return usersID;

		} finally {
			factory.close();
		}
	}

	public static void addpositions(int pos, String name) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(POSITIONS.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		String D = "UPDATE POSITIONS SET positions = :pos WHERE name = :name ";

		Query query = session.createQuery(D);
		query.setParameter("pos", pos);
		query.setParameter("name", name);
		
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);

		session.getTransaction().commit();
		System.out.println("Done!");

		factory.close();
	}

	public static int posDep(String depi) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(POSITIONS.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		POSITIONS pos =session.get(POSITIONS.class, depi);
		int num=0;
		num=pos.getPositions();

		session.getTransaction().commit();
		System.out.println("Done!");

		factory.close();
		return num;
	}

	public static void Update_Progg(String AM) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(External_User.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			String D = "UPDATE External_User SET app_progress = 1 WHERE id = :AM";

			Query query = session.createQuery(D);
			query.setParameter("AM", AM);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
		
		
	}
	public static void setAsDeclined() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(External_User.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			String D = "UPDATE External_User SET app_progress = 2 WHERE app_progress = 0";

			Query query = session.createQuery(D);
			
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}
	
}












