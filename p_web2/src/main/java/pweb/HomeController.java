package pweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	//lol
	@GetMapping("/")
	public String home() {
		return "home";
	}
}