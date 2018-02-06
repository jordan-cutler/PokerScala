case class Card(face: CardFace, suit: CardSuit) {

  def getRankName: String = face.name
  def getSuitName: String = suit.name

  override def toString: String = getRankName + getSuitName
}
