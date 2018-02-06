sealed trait CardSuit {
  val name: String
}

case object Clubs extends CardSuit {
  override val name: String = "C"
}
case object Hearts extends CardSuit {
  override val name: String = "H"
}
case object Spades extends CardSuit {
  override val name: String = "S"
}
case object Diamonds extends CardSuit {
  override val name: String = "D"
}
