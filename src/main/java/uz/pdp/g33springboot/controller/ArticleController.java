package uz.pdp.g33springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.g33springboot.dao.ArticleDao;
import uz.pdp.g33springboot.domain.Article;

import java.util.List;

@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleDao articleDao;


    @GetMapping
    public String articlePage(Model model){
        List<Article> articles = articleDao.getAll();
        model.addAttribute("articles", articles);
        return "article";
    }

    @PostMapping
    public String addArticle(@ModelAttribute Article article){
        articleDao.save(article);
        return "redirect:/articles";
    }
}
