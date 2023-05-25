package springmvcSearch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

	@RequestMapping("/user/{id}")
	public String getDat(@PathVariable("id") int id) {
		System.out.println(id);
		return "home";
	}

	@RequestMapping("/home")
	public String home() {
//		String str = null;
//		System.out.println(str.length());
		return "home";
	}

	@RequestMapping("/search")
	public RedirectView search(@RequestParam("search") String searchKey) {
		String url = "https://www.google.com/search?q=" + searchKey;
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);
		return redirectView;
	}

//	handling NullPointer Exception 
//	@ExceptionHandler(value = NullPointerException.class)
//	public String exceptionHandling() {
//		System.out.println("NullPointerException");
//		return "error";
//	}

//	handling all types of exception
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandling() {
		System.out.println("Exception occured");
		return "error";
	}

	@RequestMapping("/interceptor")
	public String interceptor() {
		return "interceptor";
	}

	@RequestMapping("/interceptorHandlerPage")
	public String interceptorHandlerPage(@RequestParam("usernm") String uname, Model model) {
		System.out.println(uname);
		model.addAttribute("uname", uname);
		return "interceptorHandlerPage";
	}

}
