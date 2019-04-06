package ch02.cats

import cats.instances.int._
import cats.instances.option._
import cats.kernel.Monoid
import cats.syntax.semigroup._

trait SuperAdder[A] {
  def id: A

  def add(items: List[A]): A
}

object SuperAdder {
  def apply[A](implicit superAdder: SuperAdder[A]): SuperAdder[A] = superAdder

  implicit def addAll: SuperAdder[Int] = new SuperAdder[Int] {
    override def id: Int = Monoid[Int].empty // 0

    override def add(items: List[Int]): Int =
      items.foldLeft(id)(_ |+| _) // items.sum
  }

  implicit def addAllOpt: SuperAdder[Option[Int]] = new SuperAdder[Option[Int]] {
    override def id: Option[Int] = Monoid[Option[Int]].empty // None

    override def add(items: List[Option[Int]]): Option[Int] =
      items.foldLeft(id)(_ |+| _) // Monoid[Option[Int]].combineAll(items)
  }

}
