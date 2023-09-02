package com.vacanspot.searchserver.domain.instagram.service;

import com.vacanspot.searchserver.domain.search.service.CrawlService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstagramService {
    private final CrawlService crawlService;

    @Value("${search.target.instagram}")
    private String instagramUrl;

    public List<String> findImagesByHashTag(
            final String hashTag
    ) {
        return crawlService.getWebElementsByUrl(instagramUrl + hashTag)
                .stream()
                .map(webElement -> webElement.getAttribute("src"))
                .toList();
    }
}
