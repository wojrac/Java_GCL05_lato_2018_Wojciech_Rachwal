package SpringBoot.REST;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Component
@PropertySource("classpath:application.properties")
@Controller
@RequestMapping("view/panel")
public class AdminController {

    @RequestMapping(value = "")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("index3");
        modelAndView.addObject("title" , "Logowanie");
        return modelAndView;
    }
    @RequestMapping(value = "log")
    public ModelAndView afterLogin() {
        ModelAndView modelAndView = new ModelAndView("index1");

        modelAndView.addObject("greetings", "Hello world from view!");
        modelAndView.addObject("greetingsArray", new String[]{"Hello", "World", "!"});

        modelAndView.addObject("title" , "log in");
        return modelAndView;
    }



}
