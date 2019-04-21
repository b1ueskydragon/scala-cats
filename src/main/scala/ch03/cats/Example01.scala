package ch03.cats

// higherKinds enabled by scalacOptions
import cats.Functor
import cats.instances.list._
import cats.instances.option._

object Example01 {

  def main(args: Array[String]): Unit = {

    val listA = List(1, 2, 3)
    val listB = Functor[List].map(listA)(_ * 2)

    println(listB)

    val optA = Option(123)
    val optB = Functor[Option].map(optA)(_ * 2)

    println(optB)

    val funcA: Int => Int = (x: Int) => x + 1

    // lifted function (operates over a functor)
    // lift converts a function of type A => B to type F[A] => F[B]
    val funcB: Option[Int] => Option[Int] = Functor[Option].lift(funcA)

    println(funcB(Option(0))) // Some(1)
    println(funcB(None)) // None

  }

}
