package ch04.cats

import cats.Monad
import cats.instances.future._
import cats.instances.vector._
import cats.syntax.flatMap._
import cats.syntax.functor._

import scala.concurrent.ExecutionContext.Implicits.global // Bringing the ExecutionContext into scope
import scala.concurrent.duration._
import scala.concurrent.{Future, _}

object Sample {

  // a generic function
  // not explicit type that is like Option or List
  def sumSquareFlatMap[F[_] : Monad](a: F[Int], b: F[Int]): F[Int] =
    a.flatMap { x =>
      b.map { y =>
        x * x + y * y
      }
    }

  def sumSquareComprehension[F[_] : Monad](a: F[Int], b: F[Int]): F[Int] =
    for {
      x <- a
      y <- b
    } yield x * x + y * y

  def main(args: Array[String]): Unit = {

    val res = Monad[Vector].flatMap(Vector(1, 2, 3))(a => Vector(a, a * 10))
    println(res) // Vector(1, 10, 2, 20, 3, 30)

    val fm = Monad[Future] // needs an ExecutionContext
    val future: Future[Int] = fm.flatMap(fm.pure(1))(x => fm.pure(x + 2))
    val res01 = Await.result(future, Duration.Inf)
    println(res01)

  }

}
