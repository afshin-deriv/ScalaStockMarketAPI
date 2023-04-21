# Stock Market API
This is a simple API for buying and selling stocks on the stock market. It's built using Scala and the Akka toolkit.

## How it Works
The API provides two endpoints: /buy and /sell. To buy or sell a stock, simply make a POST request to the appropriate endpoint with a JSON body containing the name of the stock and the desired price.

When a buy or sell request is received, it's sent to an instance of the Market actor. The Market actor keeps track of the current prices of various stocks and processes transactions as they come in. When a transaction is complete, the API responds with a simple message indicating that the transaction was successful.

## How to Compile and Run
To compile the API, you'll need to have [sbt](https://www.scala-sbt.org/) installed. Once you have sbt installed, navigate to the root directory of the project and run:
```
sbt compile
```

To run the API, run:
```
sbt run
```

This will start the API on localhost:8080. To test the API, you can use a tool like Postman to send buy and sell requests to the API.

