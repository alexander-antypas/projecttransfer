package gr.hua.dit.transfer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/")
	public String ShowMyPage() {
		return "signin";
	}
	
	@RequestMapping("/signin")
	public String Signinpage() {
		return "signin";
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
	
	@RequestMapping("/user-admin")
	public String UserAdmin() {
		return "user-admin";
	}
	
	@RequestMapping("/applist")
	public String AppList() {
		return "applist";
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
