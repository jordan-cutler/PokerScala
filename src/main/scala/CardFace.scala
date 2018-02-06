sealed trait CardFace {
  val name: String
  val value: Int
}

case object Two extends CardFace {
  override val name: String = "2"
  override val value: Int = 0
}
case object Three extends CardFace {
  override val name: String = "3"
  override val value: Int = 1
}
case object Four extends CardFace {
  override val name: String = "4"
  override val value: Int = 2
}
case object Five extends CardFace {
  override val name: String = "5"
  override val value: Int = 3
}
case object Six extends CardFace {
  override val name: String = "6"
  override val value: Int = 4
}
case object Seven extends CardFace {
  override val name: String = "7"
  override val value: Int = 5
}
case object Eight extends CardFace {
  override val name: String = "8"
  override val value: Int = 6
}
case object Nine extends CardFace {
  override val name: String = "9"
  override val value: Int = 7
}
case object Ten extends CardFace {
  override val name: String = "10"
  override val value: Int = 8
}
case object Jack extends CardFace {
  override val name: String = "J"
  override val value: Int = 9
}
case object Queen extends CardFace {
  override val name: String = "Q"
  override val value: Int = 10
}
case object King extends CardFace {
  override val name: String = "K"
  override val value: Int = 11
}
case object Ace extends CardFace {
  override val name: String = "A"
  override val value: Int = 12
}

