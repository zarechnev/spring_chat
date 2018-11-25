package org.zarechnev.chat.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    /*
    Main WEB-Page.
     */
    @RequestMapping("/")
    public String main() {
        return "index.html";
    }

    /*
    Foundation template for HTML Markup.
     */
    @RequestMapping("/foundation")
    public String foundation() {
        return "foundation.html";
    }

    @RequestMapping("/add_message")
    public String add_message(@RequestParam(name="name", required=false, defaultValue="Anonymous") String name,
                              @RequestParam(name="message") String message,
                              Model model) {
        model.addAttribute("name", name);
        return "index.html";
    }
}
