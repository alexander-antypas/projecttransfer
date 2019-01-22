package gr.hua.dit.transfer;

import java.util.Date;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBPositions {
	
	
	
	public static void addpositions(int informatics, int health_science,int home_economics,int geography) {
		// create session factory
        SessionFactory factory = new Configuration().
                        configure("hibernate.cfg.xml")
                        .addAnnotatedClass(POSITIONS.class)
                        .buildSessionFactory();
        
        // create session
        Session session = factory.getCurrentSession();
        
        
        
        	
              
        session.beginTransaction();
               
                
                String D="UPDATE POSITIONS SET home_economics = :home_economics "+" ,informatics = :informatics "+" ,health_science = :health_science "+" ,geography = :geography";
                
                Query query=session.createQuery(D);
                query.setParameter("informatics",informatics);
                query.setParameter("health_science",health_science);
                query.setParameter("geography",geography);
                query.setParameter("home_economics",home_economics);
                int result = query.executeUpdate();
                System.out.println("Rows affected: " + result);
                
                session.getTransaction().commit();
                System.out.println("Done!");
                 
                
        		
        	
		            factory.close();
		    }
       
	}


