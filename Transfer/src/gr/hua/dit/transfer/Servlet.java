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
			int number = Integer.parseInt(request.getParameter("documents"));
			String decision = admin.documents(number);

			HttpSession session = request.getSession();
			session.setAttribute("decision", decision);
			request.getRequestDispatcher("/documents").forward(request, response);
		}

		String score = request.getParameter("score");

		if ("Points".equals(score)) {
			Admin admin = new Admin();
			int stdsibling = Integer.parseInt(request.getParameter("stdsibling"));
			int numbersiblings = Integer.parseInt(request.getParameter("numbersiblings"));
			int income = Integer.parseInt(request.getParameter("income"));
			int town = Integer.parseInt(request.getParameter("town"));

			int points = admin.points(stdsibling, numbersiblings, income, town);

			HttpSession sess = request.getSession();
			sess.setAttribute("points", points);
			request.getRequestDispatcher("/points").forward(request, response);
		}

		// ÐÑÏÓÈÇÊÇ ÁÉÔÇÓÇÓ ÓÔÇÍ ÂÁÓÇ
		String application = request.getParameter("application");

		if ("Submit".equals(application)) {

			Date date = new Date();

			String application_id = request.getParameter("userid").toString();

			byte[] familyfile = null;
			byte[] financiallyfile = null;
			byte[] localityfile = null;

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

			String result = DBApplication.addApplication(date, application_id, familyfile, financiallyfile,
					localityfile);

			HttpSession sess = request.getSession();
			sess.setAttribute("result", result);
			request.getRequestDispatcher("/application").forward(request, response);
		}

		// ÅÌÖÁÍÉÓÇ ÏËÙÍ ÔÙÍ ÁÉÔÇÓÅÙÍ ÁÐÏ ÔÇÍ ÂÁÓÇ

		String viewall = request.getParameter("viewall");

		if ("Repository".equals(viewall)) {

			List<Application> applications = DBApplication.showApplications();

			HttpSession sess = request.getSession();
			sess.setAttribute("applications", applications);
			request.getRequestDispatcher("/user-admin").forward(request, response);
		}

		// ÅÌÖÁÍÉÓÇ ÓÕÃÊÅÊÑÉÌÅÍÇÓ ÁÉÔÇÓÇÓ ÌÅ ÂÁÓÇ ÔÏ ID

		String openapp = request.getParameter("openapp");

		if ("Open".equals(openapp)) {

			String appid = request.getParameter("appid").toString();

			List<Application> applications = DBApplication.openApplication(appid);

			HttpSession sess = request.getSession();
			sess.setAttribute("applications", applications);
			request.getRequestDispatcher("/documents").forward(request, response);

		}

		////alekosalekosalekosalekosalekosalekosalekosalekosalekosalekos
		///ADD EXTERNAL_USER
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
			int pro = 0;////////////////////////////////////////////////////PROGRESS
			
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
			External_User user2 = new External_User(id, username, surname, pw, year, age, email, uni, yoe, sem,pro);
			
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
		
		///ADD INTERNAL_USER
		String add_internal = request.getParameter("add_internal");
		if ("add_internal".equals(add_internal)) {
			
			String username = request.getParameter("username").toString();//////USERNAME
			String surname = request.getParameter("surname").toString();////////SURNAME
			String id = request.getParameter("id").toString();//////////////////ID
			String password = request.getParameter("password").toString();//////PASSWORD
			int year = Integer.parseInt(request.getParameter("year"));//////////YEAR OF BIRTH
			int age = Integer.parseInt(request.getParameter("age"));////////////AGE
			String email = request.getParameter("email").toString();////////////EMAIL
			String role = request.getParameter("role").toString();//////////////ROLE
			int yoe = Integer.parseInt(request.getParameter("yoe"));////////////YEAR OF ENROLLMENT
			String department = request.getParameter("department").toString();//DEPARTMENT
		
			String pw=password;
			try {
			pw = new BCryptPasswordEncoder().encode(password);///////////////////ENCODED PASSWORD
			}catch(NullPointerException e) {
				System.out.println("null!!!!");
				e.printStackTrace();
			}
			
			user user1 = new user(id,pw,1);
			authorities auth = new authorities(id,role);
			Internal_user user2 = new Internal_user(id,username,surname,pw,year,age,
					role,yoe,department,email);
			
			String message = "hello";
			message = InternalService.registerNewUserAccount(user1,user2,auth);

			HttpSession sess = request.getSession();
			sess.setAttribute("message", message);
			request.getRequestDispatcher("/definer").forward(request, response);
		
		}
		////SEARCH INTERNAL_USER
		String search = request.getParameter("search");
		if ("search".equals(search)) {
			
			
		}
		/////SHOW INTERNAL_USER
		String show_users = request.getParameter("show_users");
		if ("show_users".equals(show_users)) {
			
			
		}
		
	////alekosalekosalekosalekosalekosalekosalekosalekosalekosalekos
		
		
		//������ ������ ���� ����
		String Updateposi = request.getParameter("Updateposi");
		
		if ("Submit".equals(Updateposi)) {
			
			
			
			int informatics =  Integer.parseInt(request.getParameter("informatics"));
			int health_science =  Integer.parseInt(request.getParameter("health_science"));
			int home_economics =  Integer.parseInt(request.getParameter("home_economics"));
			int geography =  Integer.parseInt(request.getParameter("geography"));
			
		    DBPositions.addpositions(informatics,health_science,home_economics,geography);
		    
		   
			request.getRequestDispatcher("/secretary_menu").forward(request, response);
			
			
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
