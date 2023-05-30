package ua.com.alevel.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.PersonalFacade;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PersonalFacade personalFacade;

    public AdminController(PersonalFacade personalFacade) {
        this.personalFacade = personalFacade;
    }

    @GetMapping("/dashboard")
    public String index() {
        return "pages/user/admin/dashboard";
    }


    @GetMapping("/administration")
    public String findAllPersonals(WebRequest request, Model model) {
        model.addAttribute("pageData", personalFacade.findAllPersonal(request));
        return "pages/user/admin/post_administration";
    }

}
