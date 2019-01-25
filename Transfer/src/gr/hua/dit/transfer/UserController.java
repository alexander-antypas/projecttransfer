package gr.hua.dit.transfer;


import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.classes.Application;

@Controller
public class UserController {
	
	@RequestMapping("/definer")
	public String Definer() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String id = authentication.getName();
		
		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_USER"));
		
		boolean hasAdminRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
		
		boolean hasSecretariatnRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_SECRETARIAT"));
		
		boolean hasProfessorRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_PROFESSOR"));
		
		if(hasUserRole){
			List<Application> applications = DBApplication.showApplications();
			for (int i=0; i<applications.size(); i++) {
				Application app= applications.get(i);
				if (app.getApplication_id().equals(id)) {
					return "info_user";
				}
			}	
			return "application";
		}else if(hasProfessorRole) {
			return "user-professor";
		}else if(hasSecretariatnRole) {
			return "secretary_menu";
		}else if(hasAdminRole){
			return "admin";
		}
		return "signin";
	}
	
	@RequestMapping("/SignUp_External")
	public String SignUp_External() {
		return "SignUp_External";
	}
	
	@RequestMapping("/info_user")
	public String info_user() {
		return "info_user";
	}
	
	@RequestMapping("/Internal_id_finder")
	public String Internal_id_finder() {
		return "Internal_id_finder";
	}
	
	@RequestMapping("/admin")
	public String Admin() {
		return "admin";
	}
	
	@RequestMapping("/update_internal")
	public String UpdateInternal() {
		return "update_internal";
	}
	
	@RequestMapping("/Update_position")
	public String UpdatePosition() {
		return "Update_position";
	}
	
	@RequestMapping("/denied")
	public String denied() {
		return "access_denied";
	}
	
	@RequestMapping("/")
	public String ShowMyPage() {
		return "signin";
	}
	
	@RequestMapping("/signin")
	public String Signinpage() {
		return "signin";
	}
	
	@RequestMapping("/application")
	public String Application() {
		return "application";
	}
	
	@RequestMapping("/show")
	public String Show() {
		return "show";
	}
	
	@RequestMapping("/about")
	public String About() {
		return "about";
	}
	
	@RequestMapping("/help")
	public String Help() {
		return "help";
	}
	
	@RequestMapping("/contact")
	public String Contact() {
		return "contact";
	}
	
	@RequestMapping("/user-professor")
	public String UserAdmin() {
		return "user-professor";
	}
	
	@RequestMapping("/points")
	public String Points() {
		return "points";
	}
	
	
	@RequestMapping("/documents")
	public String Documents() {
		return "documents";
	}
	@RequestMapping("/update")
	public String Update() {
		return "update";
	}
	
	@RequestMapping("/secretary_menu")
	public String Secretary() {
		return "secretary_menu";
	}
	
	
	@RequestMapping("/updateSystem")
	public String UpdateSystem() {
		return "updateSystem";
	}
	
	@RequestMapping("/informStudents")
	public String InformStudents() {
		return "informStudents";
	}
	
	@RequestMapping("/overviewStudents")
	public String OverviewStudents() {
		return "overviewStudents";
	}
	
	@RequestMapping("/overviewSystem")
	public String OverviewSystem() {
		return "overviewSystem";
	}
	
}
