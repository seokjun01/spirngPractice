package Moonseokjun.springbootdeveloper.controller;

import Moonseokjun.springbootdeveloper.domain.Article;
import Moonseokjun.springbootdeveloper.dto.AddArticleRequest;
import Moonseokjun.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController // 객체 데이터를 JSON 형식으로 변환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;
    //HTTP 메서드가 POST일 때 전달받은 URL과 동이랗면 메서드로 매핑
    @PostMapping("/api/articles")
    // @RequestBody로 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        //요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
