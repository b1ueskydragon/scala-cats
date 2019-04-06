package ch02.cats


import cats.kernel.Monoid
import cats.syntax.semigroup._

trait SuperAdder[A] {
  def id(implicit monoid: Monoid[A]): A

  def add(items: List[A])(implicit monoid: Monoid[A]): A
}

object SuperAdder {
  def apply[A](implicit superAdder: SuperAdder[A]): SuperAdder[A] = superAdder

  implicit def addAll[A]: SuperAdder[A] = new SuperAdder[A] {
    override def id(implicit monoid: Monoid[A]): A = Monoid[A].empty

    override def add(items: List[A])(implicit monoid: Monoid[A]): A =
      items.foldLeft(id)(_ |+| _)
  }

}
