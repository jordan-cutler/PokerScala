object Main {
  def main(args: Array[String]): Unit = {
    val deck = new Deck()
//    deck.shuffle()

    val hand = new Hand()
    hand.addCard(new Card(12, 2))
    hand.addCard(new Card(11, 2))
    hand.addCard(new Card(10, 2))
    hand.addCard(new Card(9, 2))
    hand.addCard(new Card(8, 2))

    println(hand.isRoyalFlush)
    println(deck)
  }
}
