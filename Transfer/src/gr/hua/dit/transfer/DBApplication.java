package gr.hua.dit.transfer;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBApplication {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public static void main(String[] args) {
		
		 // create session factory
        SessionFactory factory = new Configuration().
                        configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Application.class)
                        .buildSessionFactory();
        
        
    	
        
        // create session
        Session session = factory.getCurrentSession();
        
        try {
                // create the student object
              //  Application application = new Application("Ανάργυρος", "Τσαδήμας", "tsadimas@hua.gr");
                
                // start a transaction
                session.beginTransaction();
                
                // save the student object
           //     session.save(application);
                
                // commit transaction
                session.getTransaction().commit();
                System.out.println("Done!");
                
        }
        finally {
                factory.close();
        }
		

	}

}
