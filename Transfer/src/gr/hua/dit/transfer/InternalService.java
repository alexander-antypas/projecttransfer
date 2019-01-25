package gr.hua.dit.transfer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InternalService {

	public static String registerNewUserAccount(user user1,Internal_user user,authorities auth) {
		// create session factory
				SessionFactory factory_Internal_User = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Internal_user.class)
						.buildSessionFactory();

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
				SessionFactory factory_user = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(user.class)
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
						.addAnnotatedClass(authorities.class)
						.buildSessionFactory();

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

					String message = "Η ΕΓΓΡΑΦΗ ΟΛΟΚΛΗΡΩΘΗΚΕ"; 
					
					return message;
				}
				
				finally {
					factory_authorities.close();
				}
		
	}

}
