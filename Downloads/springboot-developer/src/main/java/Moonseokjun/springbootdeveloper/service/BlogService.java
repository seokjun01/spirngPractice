package Moonseokjun.springbootdeveloper.service;

import Moonseokjun.springbootdeveloper.domain.Article;
import Moonseokjun.springbootdeveloper.dto.AddArticleRequest;
import Moonseokjun.springbootdeveloper.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service //빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;
    //블로그 글을 추가하는 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
