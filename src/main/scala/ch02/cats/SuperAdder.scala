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

  // define a monoid instance for `Order`
  implicit val monoid: Monoid[Order] = new Monoid[Order] {

    override def empty: Order = Order(0d, 0d)

    override def combine(x: Order, y: Order): Order =
      Order(x.totalCost + y.totalCost, x.quantity + y.quantity)

  }

}

case class Order(totalCost: Double, quantity: Double)

