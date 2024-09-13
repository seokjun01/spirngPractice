package Moonseokjun.springbootdeveloper.controller;

import Moonseokjun.springbootdeveloper.domain.Article;
import Moonseokjun.springbootdeveloper.dto.ArticleListViewResponse;
import Moonseokjun.springbootdeveloper.dto.ArticleViewResponse;
import Moonseokjun.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        //리스트를 저장할 수 있는 자료형 <>제네릭 이용하여 리스트에 저장될 자료형
        List<ArticleListViewResponse> articles =blogService.findAll().stream()
                .map(ArticleListViewResponse::new)//가져온데이터를 괄호안에 형태로 변경
                .toList(); //리스트에 담음
        model.addAttribute("articles", articles);

        return "articlesList";
    }
    @GetMapping("/articles/{id}")
    public String getArticles(@PathVariable Long id,  Model model) {

        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }
}
