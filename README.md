# GTA V API

This project is a Spring Boot application that provides an API for interacting with data related to the game Grand Theft Auto V (GTA V) with Fivem cars and spawn names. The application is written in Java and uses SQL for data persistence.

## Overview

The application scrapes data from a Google Spreadsheet that contains information about cars in GTA V. The scraped data is then stored in a database and exposed via a REST API.

The main entities in the application are:

- `CarOnSale`: Represents a car that is currently on sale. It has properties such as `id`, `displayName`, `price`, `date`, and `spawnName`. Please note that the data related to cars on sale is intended for a side project use.
- `Car`: Represents a car in GTA V. It has properties such as `id`, `displayName`, `price`, `date`, and `spawnName`.

The main services in the application are:

- `WebScrapingService`: Handles the scraping of car data from the Google Spreadsheet. It uses the Jsoup library to parse the HTML of the spreadsheet and extract the relevant data.
- `CarOnSaleService`: Provides methods for interacting with `CarOnSale` entities. It uses the `CarOnSaleRepository` to persist and retrieve data.
- `CarService`: Provides methods for interacting with `Car` entities. It uses the `CarRepository` to persist and retrieve data.
## API

The API is hosted at `https://gtav-api-production.up.railway.app/api`. It provides endpoints for interacting with the `CarOnSale` and `Car` entities.

## Swagger Documentation

The Swagger documentation for the API is available at `https://gtav-api-production.up.railway.app/swagger-ui/index.html`. It provides detailed information about the available endpoints, their parameters, and their responses.

## Running the Application

To run the application, you need to have Java and Maven installed on your machine. You can then clone the repository and run the application using the following command:

```bash
mvn spring-boot:run
```

This will start the application and you can access the API at `localhost:8080/api`.

## Contributing

Contributions are welcome. Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License.