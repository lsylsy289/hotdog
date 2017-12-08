package hotdog.commons.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam(required=false) String fail, @RequestParam(required=false) String logout) {

		ModelAndView mv = new ModelAndView();

		if ( null != fail ) {

			mv.addObject("fail", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}

		if ( null != logout ) {

			mv.addObject("msg", "로그아웃을 성공하였습니다.");
		}

		mv.setViewName("login/login.tiles");

		return mv;
	}
}
