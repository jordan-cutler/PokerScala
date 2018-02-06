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
    getCurrentHand.reduce((left, right) => {
      if (left.rank != right.rank - 1) return false
      right
    })
    !isStraightFlush
  }

  def isStraightFlush: Boolean = {
    isStraight && isFlush
  }

  def isRoyalFlush: Boolean = {
    (getCurrentHand.maxBy(_.rank).rank - getCurrentHand.minBy(_.rank).rank == 4) && handSize == 5 && allSuitsSame
  }

  override def toString: String = {
    getCurrentHand.mkString(" ")
  }

  private def setsOfCardsWithNSameRank(n: Int): Int = {
    getCurrentHand.groupBy(_.rank).count { case (rank, cardsWithGivenRank) => cardsWithGivenRank.length == n}
  }

  private def allSuitsSame: Boolean = {
    getCurrentHand.map(_.getSuitName).toSet.size == 1
  }

  private def getCurrentHand: Seq[Card] = {
    hand.toSeq.slice(0, handSize)
  }

  private def cardsNotSameReference(x: Card, y: Card): Boolean = {
    !(x eq y)
  }
}
