package ch02.cats


import cats.kernel.Monoid
import cats.syntax.semigroup._

trait SuperAdder {

  def add[A: Monoid](items: List[A]): A

}

object SuperAdder {
  def apply[A](implicit superAdder: SuperAdder): SuperAdder = superAdder

  implicit def addAll: SuperAdder = new SuperAdder {

    override def add[A: Monoid](items: List[A]): A =
      items.foldLeft(Monoid[A].empty)(_ |+| _)

  }

}
