package ch02.monoids

import ch02.cats.SuperAdder

import cats.instances.int._
import cats.instances.option._

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

    val superAdderInt = SuperAdder[Int]
    val res03 = superAdderInt.add(List(1, 2, 3, 4))
    println(res03)

    val superAdderIntOpt = SuperAdder[Option[Int]]
    val res04 = superAdderIntOpt.add(List(Some(100), None, Some(200)))
    println(res04)

  }

}
