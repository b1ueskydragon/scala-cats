package ch02.cats


import cats.kernel.Monoid
import cats.syntax.semigroup._

trait SuperAdder[A] {

  def add(items: List[A])(implicit monoid: Monoid[A]): A

}

object SuperAdder {

  def apply[A](implicit superAdder: SuperAdder[A]): SuperAdder[A] = superAdder

  implicit def addAll[A]: SuperAdder[A] = new SuperAdder[A] {
    // monoid instance to generic
    override def add(items: List[A])(implicit monoid: Monoid[A]): A =
      items.foldRight(monoid.empty)(_ |+| _)

  }

}
