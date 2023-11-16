package tdtu.edu.vn.lab08_ex1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }


    @RequestMapping(value = "/contact", method = {RequestMethod.GET, RequestMethod.POST})
    public String contact(Model model, @RequestParam(required = false) String name, @RequestParam(required = false) String age) {
        if (name != null && age != null) {

            model.addAttribute("name", name);
            model.addAttribute("age", age);
            return "contact-success";
        }else{
            return "/contact";
        }
        //System.out.print(name+age);

    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

}
