import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
import akka.event.LoggingReceive

object StockMarket {
  case class Buy(stock: String, price: Double)
  case class Sell(stock: String, price: Double)
  case class MarketData(stock: String, price: Double)

  class Market extends Actor with ActorLogging {
    val subscribers: collection.mutable.Set[ActorRef] = collection.mutable.Set.empty[ActorRef]

    def receive: Receive = LoggingReceive {
      case Buy(stock, price) =>
        // Buy stock logic
        publish(MarketData(stock, price))
      case Sell(stock, price) =>
        // Sell stock logic
        publish(MarketData(stock, price))
      case Subscribe(subscriber) =>
        subscribers += subscriber
      case Unsubscribe(subscriber) =>
        subscribers -= subscriber
    }

    def publish(marketData: MarketData): Unit = {
      subscribers.foreach(_ ! marketData)
    }
  }

  case class Subscribe(subscriber: ActorRef)
  case class Unsubscribe(subscriber: ActorRef)

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("stock-market")

    val market = system.actorOf(Props[Market], "market")

    // Subscribe to market data
    val subscriber = system.actorOf(Props[MarketDataSubscriber], "subscriber")
    market ! Subscribe(subscriber)

    // Unsubscribe from market data
    market ! Unsubscribe(subscriber)
  }

  class MarketDataSubscriber extends Actor with ActorLogging {
    def receive: Receive = LoggingReceive {
      case MarketData(stock, price) =>
        log.info(s"Stock $stock is trading at $price")
    }
  }
}
