import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import akka.actor.{ActorRef, ActorSystem, Props}

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object StockMarketApi extends App {

  implicit val system: ActorSystem = ActorSystem("stock-market")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
  
  val market: ActorRef = system.actorOf(Props[StockMarket.Market], "market")



  val routes = {
    path("buy") {
      post {
        entity(as[BuyRequest]) { buyRequest =>
          market ! StockMarket.Buy(buyRequest.stock, buyRequest.price)
          complete("Bought stock")
        }
      }
    } ~
    path("sell") {
      post {
        entity(as[SellRequest]) { sellRequest =>
          market ! StockMarket.Sell(sellRequest.stock, sellRequest.price)
          complete("Sold stock")
        }
      }
    }
  }

  val bindingFuture = Http().bindAndHandle(routes, "localhost", 8080)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())

  case class BuyRequest(stock: String, price: Double)
  case class SellRequest(stock: String, price: Double)

}

