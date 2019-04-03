package ch02.cats

import cats.Monoid
import cats.instances.string._ // for Monoid

object Example {

  def main(args: Array[String]): Unit = {

    val res: String = Monoid[String].combineN("lucky :) ", 5) // binary operation
    val res01 = Monoid[String].empty // identity

    println(res)
    println(res01)

  }

}
