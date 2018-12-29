package gr.hua.dit.transfer;

public class Admin {
	
	//екецвос циа тгм епаяйеиа тым дийаиокоцгтийым еццяажым

	public static String documents (int number) {
		String decision;
		if (number<3) {
			decision="INSUFFICIENT NUMBER OF DOCUMENTS";
			return decision;
		} else if (number==3) {
			decision="SUFFICIENT NUMBER OF DOCUMENTS";
			return decision;
		} else {
			decision="INVALID INPUT";
			return decision;
		}
		
	}
	
	//йаталетягсг помтым жоитгтг
	
	public int points (int stdsibling, int numbersiblings, int income, int town) {
		
		int points=0;
		
		if (stdsibling==1) {
			points = points+100;
		}
		
		points= points+numbersiblings*50;
		
		if (income>0 && income<=8000) {
			points=points+80;
		} else if (income>8000 && income<=12000) {
			points=points+40;
		}
		
		if (town==1) {
			points=points+100;
		}
		
		return points;
	}

}
	
