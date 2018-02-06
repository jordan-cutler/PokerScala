case class Card(rank: Int, suit: Int) {

  def getRankName: String = Card.Ranks(rank)
  def getSuitName: String = Card.Suits(suit)

  override def toString: String = getRankName + getSuitName
}

object Card {
  val Ranks = Array("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q", "A")
  val Suits = Array("C", "H", "S", "D")

  val CLUBS = 0
  val HEARTS = 1
  val SPADES = 2
  val DIAMONDS = 3
  val TWO = 0
  val THREE = 1
  val FOUR = 2
  val FIVE = 3
  val SIX = 4
  val SEVEN = 5
  val EIGHT = 6

  val NINE = 7
  val TEN = 8
  val JACK = 9
  val QUEEN = 10
  val KING = 11
  val ACE = 12
}
