package es.urjc.grupo10.blockbuster;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
    @Controller

public class GreetingController {
    @GetMapping("/home")
    public String greeting(Model model) {
        model.addAttribute("name", "Blockbuster");
        return "home_template";
    }
    

}
