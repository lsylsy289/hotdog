package hotdog.user.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserManagementController {

	private Logger logger = LoggerFactory.getLogger(UserManagementController.class);
	
	@RequestMapping(value = "/user/register.do")
	public ModelAndView getRegisterPage() {
		
		logger.debug("등록화면 진입!!!!!!!!");
		
		return new ModelAndView("user/register.tiles");
	}
	
	@RequestMapping(value = "/register.do")
	public ModelAndView register(@ModelAttribute("UserManagement") UserManagement userManagement) {
		
		logger.debug("사용자명 ::::" + userManagement);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("user/register");
		mv.addObject("user", userManagement);
		
		return mv;
	}
}
