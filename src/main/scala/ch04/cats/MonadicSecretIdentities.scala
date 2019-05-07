package ch04.cats

import cats.Id

/** Implement pure, map, and flatMap for Id */
object MonadicSecretIdentities {

  def pure[A](value: A): Id[A] = value

  def map[A, B](initial: Id[A])(func: A => B): Id[B] = func(initial)

  def flatMap[A, B](initial: Id[A])(func: A => Id[B]): Id[B] = pure(func(initial))

}
