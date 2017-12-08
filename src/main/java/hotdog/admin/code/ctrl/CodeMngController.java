package hotdog.admin.code.ctrl;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CodeMngController {

	@RequestMapping(value = "/admin/codeMng.do", method = RequestMethod.GET)
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public ModelAndView getCodeMngPage() {

		return new ModelAndView("admin/codeMng.tiles");
	}
}