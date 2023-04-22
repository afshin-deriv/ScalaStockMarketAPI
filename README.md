# Stock Market API
This is a simple API for buying and selling stocks on the stock market. It's built using Scala and the Akka toolkit.

## How it Works
The stock-market-api is built using Scala and Akka, a toolkit for building highly concurrent, distributed, and fault-tolerant systems. It uses Akka HTTP, a powerful HTTP toolkit built on top of Akka, to expose a RESTful API for buying and selling stocks in the stock market. The API is designed to be simple and easy to use, with basic validation and error handling in place.

The API endpoints are connected to an event-driven system using Akka actors, where transactions are processed asynchronously. The `StockMarket` actor manages the state of the stock market and processes buy and sell requests in a concurrent and thread-safe manner.


The API provides two endpoints: /buy and /sell. To buy or sell a stock, simply make a POST request to the appropriate endpoint with a JSON body containing the name of the stock and the desired price.

When a buy or sell request is received, it's sent to an instance of the Market actor. The Market actor keeps track of the current prices of various stocks and processes transactions as they come in. When a transaction is complete, the API responds with a simple message indicating that the transaction was successful.

## Features

- Allows users to buy and sell stocks
- Performs transactions in an event-driven manner using Akka actors
- Provides a RESTful API for interacting with the stock market
- Supports basic validation and error handling
- Includes unit tests for API routes using ScalaTest

## How to Compile and Run
To compile and run the stock-market-api, follow these steps:

1. Make sure you have [Scala](https://www.scala-lang.org/) and [sbt](https://www.scala-sbt.org/) installed on your machine.
2. Clone this repository to your local machine.
3. Navigate to the project directory: `cd stock-market-api`
4. Run the tests: `sbt test`
5. Compile the project: `sbt compile`
6. Run the API: `sbt run`
7. The API will be running at `http://localhost:8080` by default.



## Contributing

If you'd like to contribute to the stock-market-api, feel free to submit a pull request or open an issue. Contributions are always welcome!

