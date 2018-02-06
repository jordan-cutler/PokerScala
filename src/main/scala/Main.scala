import scala.collection.mutable

object Main {
  def main(args: Array[String]): Unit = {
    val deck = new Deck()
    deck.shuffle()

    val buffer = new mutable.ArrayBuffer[String]()
    for (i <- 1 to 100) {
      val hand = new Hand()
      hand.addCard(deck.dealCard())
      hand.addCard(deck.dealCard())
      hand.addCard(deck.dealCard())
      hand.addCard(deck.dealCard())
      hand.addCard(deck.dealCard())
      deck.shuffle()
      buffer.append(hand.getHandName)
    }

    buffer.foreach(println)

  }
}
