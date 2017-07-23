package hotdog.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "/main.do")
	public String getMainPage() {
	
		logger.info("진입");
		
		return "main/main.tiles";
	}
}
