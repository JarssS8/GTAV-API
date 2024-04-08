package com.jars.gtavapi.service;

import com.jars.gtavapi.entity.CarOnSale;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class WebScrapingService {

    @Autowired
    CarOnSaleService carOnSaleService;

    private final Integer[] colors = {23, 1, 20, 12};

    public void scrape() {
        HashMap<String, String> cars = new HashMap<>();
        try {
//           Download the HTML from a URL
            String urlCars = "https://docs.google.com/spreadsheets/d/e/2PACX-1vR0gTmBAmgYgvBZgeZlmG1y3flRvo-VEbviUODaIhUcsH_UkvCvTyigIHtn-OO-GZGq4zIOh8cv9KCI/pubhtml?gid=426913559";
            Document docCars = Jsoup.connect(urlCars).get();
            Elements bodys = docCars.select("tbody");
            Element boughtCars = bodys.get(0);
            Element larrysCars = bodys.get(1);

            Elements carsLarrys = larrysCars.select("tr");
            carsLarrys.remove(0);
            carsLarrys.forEach(
                    row -> {
                        if (row.select("td").size() >= 4) {
                            String displayName = row.select("td").get(0).text();
                            String spawnName = row.select("td").get(4).text();
                            cars.put(displayName, spawnName);
                        }
                    }
            );


            boughtCars.select("tr").forEach(
                    row -> {
                        if (row.select("td").size() >= 4 && !row.select("td").get(3).text().isEmpty()) {
                            String backgroundColor = row.select("td").get(3).className();
                            if (Arrays.stream(colors).anyMatch(color -> backgroundColor.contains("s" + color))) {
                                String priceStr = row.select("td").get(1).text().replace(".", "");
                                if (priceStr.chars().allMatch(Character::isDigit)) {
                                    row.select("td").get(2).text();
                                    String date = row.select("td").get(0).text();
                                    String displayName = row.select("td").get(2).text();
                                    CarOnSale carOnSale = new CarOnSale();
                                    carOnSale.setDisplayName(displayName);
                                    carOnSale.setSpawnName(cars.get(displayName));
                                    carOnSale.setPrice(Integer.parseInt(priceStr));
                                    carOnSale.setDate(date);
                                    carOnSaleService.saveCar(carOnSale);
                                }
                            }
                        }

                    }
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
