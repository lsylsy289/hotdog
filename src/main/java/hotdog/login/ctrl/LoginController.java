package hotdog.login.ctrl;

import hotdog.login.svc.LoginService;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name = "loginService")
	private LoginService loginService;
	
	@RequestMapping(value = "/login.do")
	public String getLoginPage() {
		
		return "login/login.tiles";
	}
	
	@RequestMapping(value = "/login/confirm.do")
	public String loginConfirm(@RequestParam String userId, @RequestParam String password, HttpServletRequest req, Model model) throws Exception {
		
		final String MAIN_URL = "/main.do", LOGIN_URL = "/login.do";

		try {
			
			Map<String, Object> userInfo = loginService.selectConfirm(userId);
			
			if ( userInfo.get("password").equals(password) ) {
				
				req.getSession().setAttribute("userId", userInfo.get("userId"));
				
				logger.info("로그인성공!!!");
				
				return "forward:" + MAIN_URL;
			} else {
				
				model.addAttribute("resultCode", "LOGIN_FAIL");
				
				return "forward:" + LOGIN_URL;
			}
		} catch (Exception e) {
			
			model.addAttribute("resultCode", "NOT_EXIST");
			
			return "forward:" + LOGIN_URL;
		}
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession hs) {
	
		hs.invalidate();

		return "redirect:/main.do";
	}
}
