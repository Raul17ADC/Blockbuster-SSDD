package es.urjc.grupo10.blockbuster;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/Home")
    public String Home(Model model) {
        model.addAttribute("name", "Blockbuster");
        return "Home_template";
    }

}
