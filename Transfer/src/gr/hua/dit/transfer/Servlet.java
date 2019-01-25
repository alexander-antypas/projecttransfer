package gr.hua.dit.transfer;


import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@MultipartConfig(maxFileSize = 1699999999)
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	//@Autowired
	//private PasswordEncoder passwordEncoder;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		String button = request.getParameter("button");

		if ("Submit".equals(button)) {
			Admin admin = new Admin();
			
			String documents = request.getParameter("documents");

			if(documents=="") {
				String decision = "ΣΥΜΠΛΗΡΩΣΤΕ ΟΛΑ ΤΑ ΚΕΝΑ";
				
				HttpSession session = request.getSession();
				session.setAttribute("decision", decision);
				request.getRequestDispatcher("/documents").forward(request, response);
			}else {
				int number = Integer.parseInt(documents);
				String decision;
				if (number<0) {
					decision="!!";
					HttpSession session = request.getSession();
					session.setAttribute("decision", decision);
					request.getRequestDispatcher("/documents").forward(request, response);
				}else{
					decision = admin.documents(number);
					
					HttpSession session = request.getSession();
					session.setAttribute("decision", decision);
					request.getRequestDispatcher("/documents").forward(request, response);
				}
			}
		}

		String score = request.getParameter("score");

		if ("Points".equals(score)) {
			Admin admin = new Admin();
			
			String par1 = request.getParameter("stdsibling");
			String par2 = request.getParameter("numbersiblings");			
			String par3 = request.getParameter("income");
			String par4 = request.getParameter("town");
			
			String appid = request.getParameter("appid").toString();
			
			if( par1=="" || par2==""|| par3=="" || par4=="") {
				String message="ΣΥΜΠΛΗΡΩΣΤΕ ΟΛΑ ΤΑ ΚΕΝΑ";
				
				HttpSession sess=request.getSession(); 
				sess.setAttribute("message", message);
				request.getRequestDispatcher("/points").forward(request, response);
				
			} else {
				int stdsibling = Integer.parseInt(par1);
				int numbersiblings = Integer.parseInt(par2);
				int income = Integer.parseInt(par3);
				int town = Integer.parseInt(par4);
				
				int points = admin.points(stdsibling, numbersiblings, income, town);				
											
				HttpSession sess=request.getSession(); 
				sess.setAttribute("points", points);
				sess.setAttribute("appid", appid);
				request.getRequestDispatcher("/points").forward(request, response);
			}
	
		}

		// ÐÑÏÓÈÇÊÇ ÁÉÔÇÓÇÓ ÓÔÇÍ ÂÁÓÇ
		String application = request.getParameter("application");

		if ("Submit".equals(application)) {

			Date date = new Date();

			String application_id = request.getParameter("userid").toString();
			int isChecked = 0;
			
			byte[] familyfile=null;
			byte[] financiallyfile=null;
			byte[] localityfile=null;
			
			try {
				Part family = request.getPart("family");
				InputStream is1 = family.getInputStream();
				familyfile = IOUtils.toByteArray(is1);

				Part financially = request.getPart("financially");
				InputStream is2 = financially.getInputStream();
				financiallyfile = IOUtils.toByteArray(is2);

				Part locality = request.getPart("locality");
				InputStream is3 = locality.getInputStream();
				localityfile = IOUtils.toByteArray(is3);

			} catch (IllegalStateException e) {
				System.out.print("FILE TOO BIG!");
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
			
		    String result= DBApplication.addApplication(date, application_id, isChecked, familyfile, financiallyfile, localityfile);
			
			HttpSession sess = request.getSession();
			sess.setAttribute("result", result);
			request.getRequestDispatcher("/application").forward(request, response);
		}

		// VIEW ALL APPLICATIONS THAT HAVE NOT YET CHECKED

		String viewall = request.getParameter("viewall");

		if ("Repository".equals(viewall)) {

			List<Application> applications = DBApplication.showApplications();

			HttpSession sess = request.getSession();
			sess.setAttribute("applications", applications);
			request.getRequestDispatcher("/user-professor").forward(request, response);
		}
		
		
		//SEARCH
		
		String searchuserid = request.getParameter("searchuserid");
		
		if("searchuserid".equals(searchuserid)){
			String appid = request.getParameter("appid");
			
			if (appid=="") {
				String message = "ΠΛΗΚΤΡΟΛΟΓΕΙΣΤΕ ΚΑΠΟΙΟ ID";
				
				HttpSession sess = request.getSession();
				sess.setAttribute("message", message);
				request.getRequestDispatcher("/user-professor").forward(request, response);
			}else {
				
				List<Application> applications = DBApplication.showApplications();
				int b=0;
				for (int i=0; i<applications.size(); i++) {
					Application paparitsa= applications.get(i);
					if (paparitsa.getApplication_id().equals(appid)) {
						b=1;
					}
				}
				if(b==1) {
					HttpSession sess = request.getSession();
					sess.setAttribute("appid", appid);
					request.getRequestDispatcher("/documents").forward(request, response);
				}else {
					String message = "ΤΟ ID ΔΕΝ ΥΠΑΡΧΕΙ, ΠΛΗΚΤΡΟΛΟΓΕΙΣΤΕ ΚΑΠΟΙΟ ΑΛΛΟ";
					HttpSession sess = request.getSession();
					sess.setAttribute("message", message);
					request.getRequestDispatcher("/user-professor").forward(request, response);
				}
			}
		}
		
		//OPEN FILES OF APPLICATION WITH USER_ID
		String familydownload = request.getParameter("family");
		
		if("family".equals(familydownload)) {
			String appid = request.getParameter("appid").toString();
			byte[] family = DBApplication.loadFamily(appid);
			ServletOutputStream os1 = response.getOutputStream();
			response.setContentType("file/pdf");
			os1.write(family);
			os1.close();
		}
				
		String financiallydownload = request.getParameter("financially");
		
		if("financially".equals(financiallydownload)) {
			String appid = request.getParameter("appid").toString();
			
			byte[] financially = DBApplication.loadFinancially(appid);
			ServletOutputStream os2 = response.getOutputStream();
			response.setContentType("file/pdf");
			os2.write(financially);
			os2.close();	
		}
		
		String localitydownload = request.getParameter("locality");
		
		if("locality".equals(localitydownload)) {
			String appid = request.getParameter("appid").toString();
			
			byte[] locality = DBApplication.loadLocality(appid);
			ServletOutputStream os3 = response.getOutputStream();
			response.setContentType("file/pdf");
			os3.write(locality);
			os3.close();
		}	
		
		String add_external = request.getParameter("add_external");
		if ("add".equals(add_external)) {
			
			String username = request.getParameter("username").toString();//USERNAME
			String surname = request.getParameter("surname").toString();////SURNAME
			String id = request.getParameter("id").toString();//////////////ID
			String password = request.getParameter("password").toString();//PASSWORD
			String uni = request.getParameter("uni").toString();////////////UNIVERSITY
			int year = Integer.parseInt(request.getParameter("year"));//////YEAR OF BIRTH
			int age = Integer.parseInt(request.getParameter("age"));////////AGE
			String email = request.getParameter("email").toString();////////EMAIL
			int yoe = Integer.parseInt(request.getParameter("yoe"));////////YEAR OF ENROLLMENT
			
			Calendar cal = Calendar.getInstance();
			int yeartoday = cal.get(Calendar.YEAR);
			int sem = (yeartoday - yoe) * 2 + 1;////////////////////////////SEMESTER

			String pw=password;
			try {
			pw = new BCryptPasswordEncoder().encode(password);///////////////////ENCODED PASSWORD
			}catch(NullPointerException e) {
				System.out.println("null!!!!");
				e.printStackTrace();
			}
			
			user user1 = new user(id,pw,1);
			authorities auth = new authorities(id,"ROLE_USER");
			External_User user2 = new External_User(id, username, surname, pw, year, age, email, uni, yoe, sem);
			
			String message = "hello";
			try {
				message = UserService.registerNewUserAccount(user1,user2,auth);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			HttpSession sess = request.getSession();
			sess.setAttribute("message", message);
			request.getRequestDispatcher("/signin").forward(request, response);

		}

		
		//approved
		
		String check = request.getParameter("check");
		
		if ("check".equals(check)) {
			
			Date date = new Date();
			int is_Approved = Integer.parseInt(request.getParameter("is_Approved"));
			int points = Integer.parseInt(request.getParameter("points"));
			String check_id = request.getParameter("appid");
			
			String result = DBApplication.check_application(date, is_Approved, points, check_id);
			DBApplication.updateCheck_id(check_id);
			
			HttpSession sess = request.getSession();
			sess.setAttribute("result", result);	
			request.getRequestDispatcher("/points").forward(request, response);
		}
		
		String Updateposi = request.getParameter("Updateposi");
		
		if ("Submit".equals(Updateposi)) {
			
			
			
			int informatics =  Integer.parseInt(request.getParameter("informatics"));
			int health_science =  Integer.parseInt(request.getParameter("health_science"));
			int home_economics =  Integer.parseInt(request.getParameter("home_economics"));
			int geography =  Integer.parseInt(request.getParameter("geography"));
			
		    DBPositions.addpositions(informatics,health_science,home_economics,geography);
		    
		   
			request.getRequestDispatcher("/secretary_menu").forward(request, response);
			
			
		}
		
		//�������� �������
		String declined = request.getParameter("declined");
		if ("declined".equals(declined)) {
			
			Date date = new Date();
			int is_Approved = Integer.parseInt(request.getParameter("is_Approved"));
			int points = Integer.parseInt(request.getParameter("points"));
			String check_id = request.getParameter("appid");
			
			String result = DBApplication.check_application(date, is_Approved, points, check_id);
			
			DBApplication.updateCheck_id(check_id);
			
			HttpSession sess = request.getSession();
			sess.setAttribute("result", result);
			request.getRequestDispatcher("/user-professor").forward(request, response);
		}
	
		
		//��������� ������ �������������
        String SystemSub = request.getParameter("SystemSub");
		
		if ("Submit".equals(SystemSub)) {
			
			String checkboxValue1 = request.getParameter("opa");
			String checkboxValue2 = request.getParameter("ekpa");
			String checkboxValue3 = request.getParameter("unipi");
		
			if (checkboxValue1 != null) {
				String name= "OPA"; 
				int status= 1;
				String sstatus=Integer.toString(status);
				 DBExternal_Department.Update(name,sstatus);
				} else{
					
					String name= "OPA"; 
					int status= 0;
					String sstatus=Integer.toString(status);
					 DBExternal_Department.Update(name,sstatus);
				}
			
			
					
			if (checkboxValue2 != null) {
				String name= "EKPA"; 
				int status= 1;
				String sstatus=Integer.toString(status);
				 DBExternal_Department.Update(name,sstatus);
				}else{
					
					String name= "EKPA"; 
					int status= 0;
					String sstatus=Integer.toString(status);
					 DBExternal_Department.Update(name,sstatus);
				}
			
			
			
			if (checkboxValue3 != null) {
				String name= "UNIPI"; 
				int status= 1;
				String sstatus=Integer.toString(status);
				 DBExternal_Department.Update(name,sstatus);
				}else{
					String name= "UNIPI"; 
					int status= 0;
					String sstatus=Integer.toString(status);
					DBExternal_Department.Update(name,sstatus);
				}
			
		   
			request.getRequestDispatcher("/Update_position").forward(request, response);
			
			
		}
		
		
		
	}
}
