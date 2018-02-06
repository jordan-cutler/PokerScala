class Hand {
  val hand: Array[Card] = Array.fill(5) {
    new Card(-1, -1)
  }
  private var handSize = 0

  def addCard(card: Card): Boolean = {
    if (handSize >= hand.length) return false
    hand(handSize) = card
    handSize = handSize + 1
    hand.sortBy(_.rank)
    true
  }

  def lookup(n: Int): Card = {
    if (n < 0 || n > (hand.length - 1)) return null
    hand(n)
  }

  def replace(n: Int, card: Card): Boolean = {
    if (n < 0 || n > (hand.length - 1)) return false
    hand(n) = card
    true
  }

  def isOnePair: Boolean = {
    setsOfCardsWithNSameRank(2) == 1 && !isFullHouse
  }

  def isTwoPair: Boolean = {
    setsOfCardsWithNSameRank(2) == 2
  }

  def isThreeOfAKind: Boolean = {
    setsOfCardsWithNSameRank(3) == 1 && !isFullHouse
  }

  def isFourOfAKind: Boolean = {
    setsOfCardsWithNSameRank(4) == 1
  }

  def isFullHouse: Boolean = {
    setsOfCardsWithNSameRank(2) == 1 && setsOfCardsWithNSameRank(3) == 1
  }

  def isFlush: Boolean = {
    allSuitsSame && handSize == 5 && !isStraightFlush && !isRoyalFlush
  }

  def isStraight: Boolean = {
    cardsSequential && handSize == 5 && !isStraightFlush
  }

  def isStraightFlush: Boolean = {
    cardsSequential && allSuitsSame && handSize == 5
  }

  def isRoyalFlush: Boolean = {
    (getCurrentHand.maxBy(_.rank).rank - getCurrentHand.minBy(_.rank).rank == 4) && handSize == 5 && allSuitsSame
  }

  def getHandName: String = {
    if (isRoyalFlush) "ROYALFLUSH"
    else if (isStraightFlush) "STRAIGHTFLUSH"
    else if (isFullHouse) "FULLHOUSE"
    else if (isFlush) "FLUSH"
    else if (isStraight) "ISSTRAIGHT"
    else if (isFourOfAKind) "ISFOUROFAKIND"
    else if (isThreeOfAKind) "ISTHREEOFAKIND"
    else if (isTwoPair) "ISTWOPAIR"
    else if (isOnePair) "ISONEPAIR"
    else "NOTHING"
  }

  override def toString: String = {
    getCurrentHand.mkString(" ")
  }

  private def cardsSequential: Boolean = {
    getCurrentHand.maxBy(_.rank).rank - getCurrentHand.minBy(_.rank).rank == 4 && handSize == 5
  }

  private def setsOfCardsWithNSameRank(n: Int): Int = {
    getCurrentHand.groupBy(_.rank).count { case (rank, cardsWithGivenRank) => cardsWithGivenRank.length == n}
  }

  def allSuitsSame: Boolean = {
    getCurrentHand.map(_.getSuitName).toSet.size == 1
  }

  private def getCurrentHand: Seq[Card] = {
    hand.toSeq.slice(0, handSize)
  }

  private def cardsNotSameReference(x: Card, y: Card): Boolean = {
    !(x eq y)
  }
}
