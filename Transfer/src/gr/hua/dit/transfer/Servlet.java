package gr.hua.dit.transfer;

import java.io.IOException;
import java.io.InputStream;

import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize=1699999999)
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String button = request.getParameter("button");
		
		if ("Submit".equals(button)) {
			Admin admin= new Admin();		
			int number = Integer.parseInt(request.getParameter("documents"));
			String decision = admin.documents(number);
			
			HttpSession session=request.getSession(); 
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
			
			
			String appid = request.getParameter("appid").toString();
						
			HttpSession sess=request.getSession(); 
			sess.setAttribute("points", points);
			sess.setAttribute("appid", appid);
			request.getRequestDispatcher("/points").forward(request, response);
		}
		
		
		//–—œ”»« « ¡…‘«”«” ”‘«Õ ¬¡”«
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
				
			}catch(IllegalStateException e){
				System.out.print("FILE TOO BIG!");
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
			
		    String result= DBApplication.addApplication(date, application_id, isChecked, familyfile, financiallyfile, localityfile);
			
			HttpSession sess = request.getSession();
			sess.setAttribute("result", result);	
			request.getRequestDispatcher("/application").forward(request, response);
		}
		
		//≈Ã÷¡Õ…”« œÀŸÕ ‘ŸÕ ¡…‘«”≈ŸÕ ¡–œ ‘«Õ ¬¡”«
		
		String viewall = request.getParameter("viewall");
		
		if("Repository".equals(viewall)) {
			
			List <Application> applications = DBApplication.showApplications();
			
			HttpSession sess = request.getSession();
			sess.setAttribute("applications", applications);
			request.getRequestDispatcher("/user-professor").forward(request, response);
		}
		
		//≈Ã÷¡Õ…”« ”’√ ≈ —…Ã≈Õ«” ¡…‘«”«” Ã≈ ¬¡”« ‘œ ID	
		
		String openapp = request.getParameter("openapp");
		
		if ("Open".equals(openapp)) {
			
			String appid = request.getParameter("appid").toString();
			
			Application app = DBApplication.openApplication(appid);
					
			HttpSession sess = request.getSession();
			sess.setAttribute("app", app);
			request.getRequestDispatcher("/documents").forward(request, response);
					
		}
		
		//≈√ —…”« ¡…‘«”«”
		
		String check = request.getParameter("check");
		
		if ("check".equals(check)) {
			
			Date date = new Date();
			int is_Approved = Integer.parseInt(request.getParameter("is_Approved"));
			int points = Integer.parseInt(request.getParameter("points"));
			String check_id = request.getParameter("appid");
			
			String result = DBApplication.check_application(date, is_Approved, points, check_id);
			
			HttpSession sess = request.getSession();
			sess.setAttribute("result", result);	
			request.getRequestDispatcher("/points").forward(request, response);
		}
		
		//¡–œ——…ÿ« ¡…‘«”«”
		String declined = request.getParameter("declined");
		if ("declined".equals(declined)) {
			
			Date date = new Date();
			int is_Approved = Integer.parseInt(request.getParameter("is_Approved"));
			int points = Integer.parseInt(request.getParameter("points"));
			String check_id = request.getParameter("appid");
			
			String result = DBApplication.check_application(date, is_Approved, points, check_id);
			
			HttpSession sess = request.getSession();
			sess.setAttribute("result", result);	
			request.getRequestDispatcher("/user-professor").forward(request, response);
		}
	
		
	}

}
	
