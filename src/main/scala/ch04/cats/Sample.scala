package ch04.cats

import cats.Monad
import cats.instances.future._
import cats.instances.vector._
import cats.syntax.flatMap._
import cats.syntax.functor._

import scala.concurrent.ExecutionContext.Implicits.global // Bringing the ExecutionContext into scope
import scala.concurrent.Future

object Sample {

  def dupliAndCarry(a: Vector[Int]): Vector[Int] = Monad[Vector].flatMap(a)(x => Vector(x, x * 10))

  // needs an ExecutionContext
  private val futureMonad = Monad[Future]

  def future(a: Int): Future[Int] =
    futureMonad.flatMap(futureMonad.pure(a))(x => futureMonad.pure(x + 2))

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

}
