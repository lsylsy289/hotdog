package hotdog.user.ctrl;

import hotdog.user.svc.UserManagementService;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserManagementController {

	private Logger logger = LoggerFactory.getLogger(UserManagementController.class);
	
	@Resource(name = "userManagementService")
	private UserManagementService userManagementService;
	
	@RequestMapping(value = "/user/register.do")
	public ModelAndView getRegisterPage() {
		
		return new ModelAndView("user/register.tiles");
	}
	
	@RequestMapping(value = "/user/userRegister.do", method = RequestMethod.POST)
	public String userRegister(@ModelAttribute UserManagementVO userManagementVO, HttpServletResponse res, Model model) throws IOException {
		
		int resultRow = userManagementService.insertUser(userManagementVO);
		
		model.addAttribute("resultCode", (resultRow > 0) ? "SUCCESS" :  "FAIL");
		
		return "user/register.tiles";
	}
}
