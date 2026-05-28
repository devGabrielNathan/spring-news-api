package br.com.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.news.dto.NewsPatchRequest;
import br.com.news.dto.NewsRequest;
import br.com.news.dto.NewsResponse;
import br.com.news.entity.News;
import br.com.news.mapper.NewsMapper;
import br.com.news.repository.NewsRepository;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    @Autowired
    public NewsService(NewsRepository newsRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    public List<NewsResponse> findAll() {
        return newsMapper.toResponseList(newsRepository.findAll());
    }

    public NewsResponse findById(Long id) {
        return newsMapper.toResponse(newsRepository.findById(id).orElseThrow());
    }

    public NewsResponse create(NewsRequest request) {
        News news = newsMapper.toEntity(request);
        return newsMapper.toResponse(newsRepository.save(news));
    }

    public NewsResponse update(Long id, NewsRequest request) {
        newsRepository.findById(id).orElseThrow();
        News newsToUpdate = newsMapper.toEntity(request);
        newsToUpdate.setId(id);
        return newsMapper.toResponse(newsRepository.save(newsToUpdate));
    }

    public NewsResponse patch(Long id, NewsPatchRequest request) {
        News news = newsRepository.findById(id).orElseThrow();
        newsMapper.updateEntityFromPatch(news, request);
        return newsMapper.toResponse(newsRepository.save(news));
    }

    public void delete(Long id) {
        newsRepository.deleteById(id);
    }
}
