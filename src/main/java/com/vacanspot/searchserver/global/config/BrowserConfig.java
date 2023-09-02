package com.vacanspot.searchserver.global.config;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class BrowserConfig {

    @Value("${browser.name}")
    private String browserName;

    @Value("${browser.driver.path}")
    private String browserDriverPath;

    @Bean
    public FirefoxDriver firefoxDriver() {
        System.setProperty(browserName, Paths.get(browserDriverPath).toString());

        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");

        return new FirefoxDriver(options);
    }

    @Bean
    public WebDriverWait webDriverWait(
            final FirefoxDriver driver
    ) {
        return new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
    }
}
