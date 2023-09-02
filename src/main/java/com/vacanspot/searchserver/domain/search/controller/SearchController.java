package com.vacanspot.searchserver.domain.search.controller;

import com.vacanspot.searchserver.domain.instagram.service.InstagramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {
    private final InstagramService instagramService;

    @GetMapping("/search")
    public ResponseEntity<List<String>> getRecommendImages(
            @RequestParam("query") String query
    ) {
        return ResponseEntity.ok(
                instagramService.findImagesByHashTag(query)
        );
    }
}
