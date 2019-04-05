package ch02.monoids

object Main {

  def main(args: Array[String]): Unit = {

    val intSetMonoid = Monoid[Set[Int]]
    val res = intSetMonoid.combine(Set(1, 2), Set(2, 3))
    println(res)

    val strSetMonoid = Monoid[Set[String]]
    val res01 = strSetMonoid.combine(Set("A", "B"), Set("B", "C"))
    println(res01)

    val intSetSemigroup = Semigroup[Set[Int]]
    val res02 = intSetSemigroup.combine(Set(1, 2), Set(2, 3))
    println(res02)

  }

}
