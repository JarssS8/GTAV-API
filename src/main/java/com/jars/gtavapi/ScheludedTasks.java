package com.jars.gtavapi;

import com.jars.gtavapi.service.WebScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheludedTasks {
    @Autowired
    private WebScrapingService webScrapingService;

    // 5 minutes = 300,000 milliseconds
    @Scheduled(fixedRate = 5  * 60 * 1000)
    public void scrape() {
        webScrapingService.scrape();
    }
}
