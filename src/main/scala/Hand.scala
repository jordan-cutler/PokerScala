class Hand(hand: Array[Card]) {
  
  require(hand.length == 5)

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
    allSuitsSame && !isStraightFlush && !isRoyalFlush
  }

  def isStraight: Boolean = {
    cardsSequential && !isStraightFlush
  }

  def isStraightFlush: Boolean = {
    cardsSequential && allSuitsSame
  }

  def isRoyalFlush: Boolean = {
    val maxCard = hand.maxBy(_.face.value)
    val minCard = hand.minBy(_.face.value)
    maxCard.face == Ace && minCard.face == Ten && allSuitsSame
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
    hand.mkString(" ")
  }

  private def cardsSequential: Boolean = {
    hand.maxBy(_.face.value).face.value - hand.minBy(_.face.value).face.value == 4
  }

  private def setsOfCardsWithNSameRank(n: Int): Int = {
    hand.groupBy(_.face).count { case (rank, cardsWithGivenRank) => cardsWithGivenRank.length == n}
  }

  def allSuitsSame: Boolean = {
    hand.map(_.getSuitName).toSet.size == 1
  }
  
}
