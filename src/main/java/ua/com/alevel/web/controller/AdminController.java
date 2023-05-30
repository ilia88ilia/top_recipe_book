package ua.com.alevel.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.PersonalFacade;
import ua.com.alevel.facade.PostFacade;
import ua.com.alevel.persistence.entity.post.Post;
import ua.com.alevel.persistence.entity.user.Personal;
import ua.com.alevel.service.PersonalService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {



   @GetMapping("/dashboard")
   public String index() {
       return "pages/user/admin/dashboard";
   }

}
