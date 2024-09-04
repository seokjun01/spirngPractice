package Moonseokjun.springbootdeveloper.dto;
//DTO는 계층끼리 데이터 교환하기 위해 사용하는 객체(전달자 역할)
//DAO는 데이터베이스와 연결되고 데이터를 조회하고 수정하는 데 사용하는 객체

import Moonseokjun.springbootdeveloper.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {

    private String title;
    private String content;
//빌더 패턴을 사용하여 DTO를 엔티티로 만들어주는 메서드
    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
