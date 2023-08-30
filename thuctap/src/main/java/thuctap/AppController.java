package thuctap;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import thuctap.UserService;
import thuctap.UserServiceImpl;



@Controller
/* @SessionAttributes("Email") */
public class AppController {
	
    @Autowired
    UserService userService;
    
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	@GetMapping("/gioithieu")
	public String viewGioithieu() {
		return "gioithieu";
	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "sign_up";
	}
	
	@PostMapping("/process_register")
public String processRegister(ModelMap model ,User user ) {
		if(userService.checkEmail(user.getEmail())) {
			userRepo.save(user);
			return "redirect:/login";
		}else {
			model.addAttribute("Error", "Tài khoản đã được sử dụng");
			return "sign_up";
		}
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/checklogin")
	public String checkLogin(ModelMap model, @RequestParam("email")String email,
		@RequestParam("password")String password , HttpSession session ) {
		   String a="admin@gmail.com";
            String b="admin";
			if( userService.checkLogin(email, password)) {
				session.setAttribute("Email", email);
				return "trangchu";
			} else if((email.equals(a))&&(password.equals(b))) {
				return "admin";
			}else {
				model.addAttribute("ERROR","Tài khoản hoặc mật khẩu không đúng");
		    return "login";
		}
	
	}
	
	@GetMapping("/placepassword")
	public String password() {
		return "place_password";
	}
	
	
	@PostMapping("/checkPassword")
	public String checkPassword(ModelMap model, @RequestParam("password")String password , @RequestParam("password_new")String password_new, @RequestParam("password_new_2")String password_new_2 , HttpSession session) {
		String tmp =(String) session.getAttribute("Email");
		User users = userService.findByEmail(tmp);
		if(userService.checkPassword(password, users.getPassword())&&password_new.equals(password_new_2)) {
			users.setPassword(password_new);
			userRepo.save(users);
			return "login";

		}else {
			return "place_password";
		}
	}
	
	
	@GetMapping("/logout")
	public String logOut( HttpSession session) {
		session.removeAttribute("Email");
		return "index";
	}
	@GetMapping("/lap_trinh_c++")
	public String Java(){
		return "lap_trinh_c++";
	}
	@GetMapping("/lap_trinh_java")
	public String Cplus(){
		return "lap_trinh_java";
	}
	@GetMapping("/lap_trinh_python")
	public String python(){
		return "lap_trinh_python";
	}
    @GetMapping("/trangchu")
    public String Home() {
    	return "trangchu";
    }
	
	
	@GetMapping("/member")
	public String viewKhoahoc(Model model,HttpSession session) {
		String tmp = (String) session.getAttribute("Email");
     	User users = userService.findByEmail(tmp);
		model.addAttribute("users", users);
		return "member";
	}

}
