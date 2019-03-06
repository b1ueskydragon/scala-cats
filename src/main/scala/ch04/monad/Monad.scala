package ch04.monad

import scala.language.higherKinds

trait Monad[F[_]] {

  // unit
  def pure[A](a: A): F[A]

  def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]

  // We can define map in the same way for every monad using the existing methods, flatMap and pure.
  def map[A, B](value: F[A])(func: A => B): F[B] =
    flatMap(value)(a => pure(func(a)))

  // our goal is:           A => B => F[B]
  // order of execution:   ((A => B) => F[B])
  // function composition: f(g(x))

}