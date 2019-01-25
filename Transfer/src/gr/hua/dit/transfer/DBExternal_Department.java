package gr.hua.dit.transfer;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import gr.hua.dit.classes.External_Department;

public class DBExternal_Department {

	
	
		public static Void Update(String name,String status) {
			// create session factory
	        SessionFactory factory = new Configuration().
	                        configure("hibernate.cfg.xml")
	                        .addAnnotatedClass(External_Department.class)
	                        .buildSessionFactory();
	        
	        // create session
	        Session session = factory.getCurrentSession();
	        
	        
	      
	                 session.beginTransaction();
	                 

	                 
	                 String U="UPDATE External_Department SET is_Selected = :status " + "WHERE NAME = :name " ;
	                 Query query= session.createQuery(U);
	                 query.setParameter("name",name);
	                 query.setParameter("status",status);
	                 int result =query.executeUpdate();
	                 System.out.println("Rows affected: "+result);
	                 // commit transaction
	                 
	                 session.getTransaction().commit();
	                 System.out.println("Done!");
	                 
			  
			         factory.close();
					return null;
			         
			    }
	       
		}
