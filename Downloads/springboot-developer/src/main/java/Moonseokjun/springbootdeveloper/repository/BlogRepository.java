package Moonseokjun.springbootdeveloper.repository;

import Moonseokjun.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
