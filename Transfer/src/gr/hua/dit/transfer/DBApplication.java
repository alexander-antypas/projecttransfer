package gr.hua.dit.transfer;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBApplication {

	// �������� �������� ���� ����
	public static String addApplication(Date date_of_submission, String application_id, int isChecked, byte[] family,
			byte[] financially, byte[] locality) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Application.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		String result = "AN ERROR OCCURED WHILE UPLOADING THE FILES";

		try {

			if (family != null || financially != null || locality != null) {
				// create the student object
				Application application = new Application(date_of_submission, application_id, isChecked, family,
						financially, locality);

				// start a transaction
				session.beginTransaction();

				// save the student object
				session.save(application);

				// commit transaction
				session.getTransaction().commit();
				System.out.println("Done!");

				result = "Submittion completed";

			}

			return result;
		} finally {
			factory.close();
		}

	}

	// �������� ���� ��� �������� ��� ��� ���� ��� ��� ����� �������

	public static List<Application> showApplications() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Application.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// query applications
			List<Application> applications = session.createQuery("from Application app where app.isChecked=0").getResultList();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

			return applications;

		} finally {
			factory.close();
		}

	}

	// �������� ������� �� ���� �� USER_ID
	/*
	public static Application openApplication(String appid) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Application.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// query application(s) with user_id
			Application app = session.get(Application.class, appid);
			// commit transaction
			session.getTransaction().commit();			
			System.out.println("Done!");

			return app;

		} finally {
			factory.close();
		}
	}
	*/
	
	public static byte[] loadFamily(String application_id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Application.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// query application(s) with user_id
			byte[] family = session.get(Application.class, application_id).getFamily();
			// commit transaction
			session.getTransaction().commit();			
			System.out.println("Done!");

			return family;

		} finally {
			factory.close();
		}
	}
	
	public static byte[] loadFinancially(String application_id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Application.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// query application(s) with user_id
			byte[] financially = session.get(Application.class, application_id).getFinancially();
			// commit transaction
			session.getTransaction().commit();			
			System.out.println("Done!");

			return financially;

		} finally {
			factory.close();
		}
	}
	
	public static byte[] loadLocality(String application_id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Application.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// query application(s) with user_id
			byte[] locality = session.get(Application.class, application_id).getLocality();
			// commit transaction
			session.getTransaction().commit();			
			System.out.println("Done!");

			return locality;

		} finally {
			factory.close();
		}
	}
	
	
	// INSERT CHECK APPLICATION

	public static String check_application(Date date_of_check, int is_Approved, int points, String check_id) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Check_Application.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		String result = "AN ERROR OCCURED WHILE UPLOADING THE FILES";

		try {

			// create the check_application object
			Check_Application checkapp = new Check_Application(date_of_check, is_Approved, points, check_id);

			session.beginTransaction();
			session.save(checkapp);
			session.getTransaction().commit();
			System.out.println("Done!");

			result = "Submittion completed";

			return result;
		} finally {
			factory.close();
		}

	}
	
	public static void updateCheck_id(String check_id) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Application.class)
				.buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();
				try {
					
					session.beginTransaction();

					String U="UPDATE Application SET isChecked =1 " + "WHERE application_id  = :check_id " ;
	                Query query= session.createQuery(U);
	                query.setParameter("check_id",check_id);
	                int result =query.executeUpdate();
	                System.out.println("Rows affected: "+result);
	                // commit transaction
	                 
	                session.getTransaction().commit();
					System.out.println("The update of isCheck is completed");

				} finally {
					factory.close();
				}
	}
		
}
