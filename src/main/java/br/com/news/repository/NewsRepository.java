package br.com.news.repository;

import br.com.news.util.NewsStatus;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.news.entity.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findNewsByStatusOrderByCreatedAtDesc(NewsStatus status);
}
