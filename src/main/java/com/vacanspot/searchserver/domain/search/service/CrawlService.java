package com.vacanspot.searchserver.domain.search.service;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrawlService {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    private static final int FROM_INDEX = 3;

    public List<WebElement> getWebElementsByUrl(
            final String url
    ) {
        List<WebElement> webElements = getWebElements(url);

        return slice(webElements, FROM_INDEX);
    }

    private List<WebElement> getWebElements(
            final String url
    ) {
        webDriver.get(url);

        By imgTag = By.tagName("img");

        webDriverWait.until(driver -> driver.findElements(imgTag).size() > FROM_INDEX);

        return webDriver.findElements(imgTag);
    }

    private List<WebElement> slice(
            final List<WebElement> webElements,
            final int fromIndex
    ) {
        return webElements.subList(fromIndex, webElements.size());
    }
}
