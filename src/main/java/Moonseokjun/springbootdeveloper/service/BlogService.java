package Moonseokjun.springbootdeveloper.service;

import Moonseokjun.springbootdeveloper.domain.Article;
import Moonseokjun.springbootdeveloper.dto.AddArticleRequest;
import Moonseokjun.springbootdeveloper.dto.UpdateArticleRequest;
import Moonseokjun.springbootdeveloper.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service //빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;
    //블로그 글을 추가하는 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Blog not found" + id));
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("NOT FOUND:" + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
