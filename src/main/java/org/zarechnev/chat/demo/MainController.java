package org.zarechnev.chat.demo;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Autowired
    ChatMessageRepository msgRepo;

    /*
    Main WEB-Page.
    */
    @RequestMapping("/")
    public String main() {
        return "index.html";
    }

    /*
    Return all messages in HTML-format.
     */
    @ResponseBody
    @RequestMapping("/get_messages")
    public String myMethod(){
        String response = "";
        for (ChatMessage message : msgRepo.findAll()){
            response += message.toString();
            response += "<br>";
        }
        return response;
    }

    /*
    Foundation template for HTML markup.
     */
    @RequestMapping("/foundation")
    public String foundation() {
        return "foundation.html";
    }

    /*
    Add message.
     */
    @ResponseBody
    @RequestMapping("/add_message")
    public String addMessage(@RequestParam(name="name", required=false, defaultValue="Anonymous") String name,
                             @RequestParam("message") String message) {
        try {
            msgRepo.save(new ChatMessage(name, message));
            return "successfully";
        }
        catch (Exception e) {
            return "unsuccessfully";
        }
    }
}
