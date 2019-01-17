package gr.hua.dit.transfer;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBApplication {
	
	//пяосхгйг аитгсеым стгм басг
	public static String addApplication(Date date_of_submission, String application_id, byte[] family, byte[] financially, byte[] locality) {
		// create session factory
        SessionFactory factory = new Configuration().
                        configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Application.class)
                        .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();
        
        String result="AN ERROR OCCURED WHILE UPLOADING THE FILES";
        
        try {
        	
        	if (family!=null || financially!=null || locality!=null) {        		
        		// create the student object
                Application application = new Application(date_of_submission, application_id, family, financially, locality);
                 
                 // start a transaction
                 session.beginTransaction();
                 
                 // save the student object
                 session.save(application);
                 
                 // commit transaction
                 session.getTransaction().commit();
                 System.out.println("Done!");
                 
                 result="Submittion completed";
        		
        	}
            
            	return result;
		    }
		    finally {
		            factory.close();
		    }
       
	}
	
	//елжамисг окым тым аитгсеым апо тгм басг
	
	public static List<Application> showApplications(){
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Application.class)
                .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
            // start a transaction
            session.beginTransaction();

            // query applications
            List<Application> applications = session.createQuery("from Application").getResultList();
            
          
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
            
    		return applications;

	    } finally {
	            factory.close();
	    }

	}
	
	//елжамисг аитгсгс ле басг то USER_ID
	
	public static List<Application> openApplication(String appid){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Application.class)
                .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try {
			// start a transaction
            session.beginTransaction();
            
            //query application(s) with user_id
            
            String q = "Select * from Application where application_id=:appid";
            List<Application> applications = session.createQuery(q).getResultList();
            
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
            
    		return applications;
            
		} finally {
			factory.close();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	