package gr.hua.dit.transfer;

import net.bytebuddy.utility.RandomString;


//������� ��� �������� �� APPLICATION ID RANDOM GENERATED

public class SystemHelper {
	
	public String application_id_generator() {
		
		RandomString session = new RandomString();
	
		String id = session.toString();
		
		return id;
	}

}
