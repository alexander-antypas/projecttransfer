package gr.hua.dit.transfer;

import com.mysql.cj.jdbc.Blob;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateApplication {

	public static String addApplication(Date date_of_submission, String application_id, Blob family, Blob financially, Blob locality) {
		// create session factory
        SessionFactory factory = new Configuration().
                        configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Application.class)
                        .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();
        
        try {
            // create the student object
           Application application = new Application(date_of_submission, application_id, family, financially, locality);
            
            // start a transaction
            session.beginTransaction();
            
            // save the student object
            session.save(application);
            
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
            
            String result="Submittion completed";
            return result;
    }
    finally {
            factory.close();
    }
       
	}
	
	
	
}
