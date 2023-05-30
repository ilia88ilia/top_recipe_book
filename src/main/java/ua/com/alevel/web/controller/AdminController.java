package ua.com.alevel.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.facade.PersonalFacade;
import ua.com.alevel.persistence.entity.user.Personal;
import ua.com.alevel.service.PersonalService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PersonalFacade personalFacade;

    public AdminController(PersonalFacade personalFacade, PersonalService personalService) {
        this.personalFacade = personalFacade;
    }

    @GetMapping("/dashboard")
    public String index() {
        return "pages/user/admin/dashboard";
    }


    @GetMapping("/administration")
    public String allPersonals(Model model) {
        List<Personal> personalList  = personalFacade.findAllPersonal();
        model.addAttribute("personalList", personalList);
        return "pages/user/admin/post_administration";
    }
}
