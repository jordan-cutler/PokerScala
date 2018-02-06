class Deck {
  private val deck: Array[Card] = generateDeck()
  private var nextCardIndex = 0

  private def generateDeck(): Array[Card] = {
    (for (suit <- 0 to 3; rank <- 0 to 12) yield new Card(rank, suit)).toArray
  }

  def printCards(): Unit = {
    deck.foreach(card => println(card))
  }

  def shuffle(): Unit = {
    val random = new scala.util.Random
    for (i <- deck.indices) {
      val swapIndex = 1 + random.nextInt(51)
      val temp = deck(0)
      deck(0) = deck(swapIndex)
      deck(swapIndex) = temp
    }
  }

  def dealCard(): Card = {
    val nextCard = deck(nextCardIndex)
    nextCardIndex = nextCardIndex + 1
    if (nextCardIndex == 52) nextCardIndex = 0
    nextCard
  }

  def cardsRemaining(): Int = {
    52 - nextCardIndex
  }

  override def toString: String = {
    deck.toSeq.slice(nextCardIndex, 52).mkString(" ")
  }
}
