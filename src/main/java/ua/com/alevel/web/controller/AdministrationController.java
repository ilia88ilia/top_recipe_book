package ua.com.alevel.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.alevel.facade.PersonalFacade;
import ua.com.alevel.facade.PostFacade;
import ua.com.alevel.persistence.entity.post.Post;
import ua.com.alevel.persistence.entity.user.Personal;

import java.util.List;

@Controller
@RequestMapping("/admin/administration")
public class AdministrationController {

    private final PersonalFacade personalFacade;
    private final PostFacade postFacade;

    public AdministrationController(PersonalFacade personalFacade, PostFacade postFacade) {
        this.personalFacade = personalFacade;
        this.postFacade = postFacade;
    }

    @GetMapping("/post_all")
    public String findAllPost(Model model) {
        List<Post> postList = postFacade.findAllPosts();
        model.addAttribute("postList", postList);
        return "pages/user/admin/administration/post_all";
    }

    @GetMapping("/post_details/{id}")
    public String details(Model model, @PathVariable Long id, @RequestParam("reaction") boolean reaction) {
        model.addAttribute("postFullData", postFacade.findById(id));
        model.addAttribute("reaction", reaction);
        return "pages/user/admin/administration/post_details";
    }

    @GetMapping("/personal_all")
    public String allPersonals(Model model) {
        List<Personal> personalList  = personalFacade.findAllPersonal();
        model.addAttribute("personalList", personalList);
        return "pages/user/admin/administration/personal_all";
    }
}
