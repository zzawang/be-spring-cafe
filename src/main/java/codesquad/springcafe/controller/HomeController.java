package codesquad.springcafe.controller;

import codesquad.springcafe.model.ListArticle;
import codesquad.springcafe.service.ArticleService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private final ArticleService articleService;

    @Autowired
    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(value = {"/", "/home"})
    public String showHomePage(Model model, HttpSession httpSession) {
        httpSession.removeAttribute("matchPw");
        List<ListArticle> articles = articleService.findAllArticle();
        model.addAttribute("articleList", articles);
        return "article/list";
    }
}
