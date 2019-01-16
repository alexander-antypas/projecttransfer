package gr.hua.dit.transfer;

import java.io.IOException;
import java.io.InputStream;

import com.mysql.cj.jdbc.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize=169999999)
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
			
			HttpSession sess=request.getSession(); 
			sess.setAttribute("points", points);
			request.getRequestDispatcher("/points").forward(request, response);
		}
		
		
		//–—œ”»« « ¡…‘«”«” ”‘«Õ ¬¡”«
		String application = request.getParameter("application");
		
		if ("Submit".equals(application)) {
			
			Date date = new Date();
			
			SystemHelper sh = new SystemHelper();
			String application_id = sh.application_id_generator();
			
			Part family = request.getPart("family");
			InputStream is1 = family.getInputStream();
			byte[] familyfile = IOUtils.toByteArray(is1);
			
			
			Part financially = request.getPart("financially");
			InputStream is2 = financially.getInputStream();
			byte[] financiallyfile = IOUtils.toByteArray(is2);
			
			Part locality = request.getPart("locality");
			InputStream is3 = locality.getInputStream();
			byte[] localityfile = IOUtils.toByteArray(is3);
			
						
			
			String result = CreateApplication.addApplication(date, application_id, familyfile, financiallyfile, localityfile);
			
			HttpSession sess = request.getSession();
			sess.setAttribute("result", result);
			request.getRequestDispatcher("/application").forward(request, response);
			
			
		}

	}

}
	
