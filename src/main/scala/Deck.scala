class Deck {
  private val deck: Array[Card] = Deck.Deck.toArray
  private var nextCardIndex = 0

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

  def dealHand(): Hand = {
    val cards = for (i <- 0 until 5) yield dealCard()
    new Hand(cards.toArray)
  }

  def cardsRemaining(): Int = {
    52 - nextCardIndex
  }

  override def toString: String = {
    deck.toSeq.slice(nextCardIndex, 52).mkString(" ")
  }
}

object Deck {
  val Deck = List(
    Card(Two, Clubs), Card(Three, Clubs), Card(Four, Clubs), Card(Five, Clubs), Card(Six, Clubs), Card(Seven, Clubs), Card(Eight, Clubs),
    Card(Nine, Clubs), Card(Ten, Clubs), Card(Jack, Clubs), Card(Queen, Clubs), Card(King, Clubs), Card(Ace, Clubs),

    Card(Two, Hearts), Card(Three, Hearts), Card(Four, Hearts), Card(Five, Hearts), Card(Six, Hearts), Card(Seven, Hearts), Card(Eight, Hearts),
    Card(Nine, Hearts), Card(Ten, Hearts), Card(Jack, Hearts), Card(Queen, Hearts), Card(King, Hearts), Card(Ace, Hearts),

    Card(Two, Spades), Card(Three, Spades), Card(Four, Spades), Card(Five, Spades), Card(Six, Spades), Card(Seven, Spades), Card(Eight, Spades),
    Card(Nine, Spades), Card(Ten, Spades), Card(Jack, Spades), Card(Queen, Spades), Card(King, Spades), Card(Ace, Spades),

    Card(Two, Diamonds), Card(Three, Diamonds), Card(Four, Diamonds), Card(Five, Diamonds), Card(Six, Diamonds), Card(Seven, Diamonds), Card(Eight, Diamonds),
    Card(Nine, Diamonds), Card(Ten, Diamonds), Card(Jack, Diamonds), Card(Queen, Diamonds), Card(King, Diamonds), Card(Ace, Diamonds)
  )
}
