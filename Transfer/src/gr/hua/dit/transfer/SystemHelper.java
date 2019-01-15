package gr.hua.dit.transfer;

import net.bytebuddy.utility.RandomString;


//леходос поу жтиавмеи то APPLICATION ID RANDOM GENERATED

public class SystemHelper {
	
	public String application_id_generator() {
		
		RandomString session = new RandomString();
	
		String id = session.toString();
		
		return id;
	}

}
