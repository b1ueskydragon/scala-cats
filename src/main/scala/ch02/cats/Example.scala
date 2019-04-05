package ch02.cats

import cats.Monoid
import cats.instances.string._ // for Monoid

import cats.instances.int._ // for Monoid; to assemble a Monoid[Option[Int]]
import cats.instances.option._ // for Monoid; to assemble a Monoid[Option[Int]]

import cats.syntax.semigroup._ // for combine operation

object Example {

  def main(args: Array[String]): Unit = {

    val res: String = Monoid[String].combineN("lucky :) ", 5) // binary operation
    val res01 = Monoid[String].empty // identity

    println(res)
    println(res01)

    val x = Option(11)
    val y = Option(99)

    // Option(x) + Option(y) = Option(x + y)
    // Int + Int = Int; closed
    val res02 = Monoid[Option[Int]].combine(x, y)

    println(res02) // Some(110) == Option(110)

    val res03 = "A" |+| "B" |+| Monoid[String].empty

    println(res03)

  }

}
