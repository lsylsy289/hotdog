package hotdog.main;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public String getMainPage() {

		return "main/main.tiles";
	}
}
