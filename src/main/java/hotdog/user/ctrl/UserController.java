package hotdog.user.ctrl;

import hotdog.user.svc.UserService;
import hotdog.user.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired UserService userService;
	
	@RequestMapping(value = "/user/userRegist.do")
	public String getUserRegistPage() {

		return "user/userRegist.tiles";
	}
	
	@RequestMapping(value = "/user/registUser.do")
	public @ResponseBody String registUser(@ModelAttribute UserVO userVO) throws Exception {
		
		return userService.registUser(userVO) > 0 ? "SUCESS" : "FAIL";
	}
}
