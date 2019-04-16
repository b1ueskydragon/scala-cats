package ch03.cats

import cats.instances.function._ // for Functor
import cats.syntax.functor._ // for map

/** Start with X => A
  * Supply a function A => B
  * Get back X => B
  *
  * (X => A) map (A => B) = (X => B)
  */
object Example {

  // alias X => A as funcA[A]
  val funcA: Int => Double = (x: Int) => x.toDouble

  val funcB: Double => Double = (y: Double) => y * 2

  def main(args: Array[String]): Unit = {
    val v: Int = 1

    // functional composition; g(f(x))
    val compositionMap: Double = (funcA map funcB) (v)
    val compositionAndThen: Double = (funcA andThen funcB) (v)
    val composition: Double = funcB(funcA(v))

    println(compositionMap, compositionAndThen, composition)

  }

}
